package ru.bagaev.spring.micro.servicecurrency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;
import ru.bagaev.spring.micro.servicecurrency.service.CurrencyService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import javax.annotation.PostConstruct;
import java.util.List;



@Slf4j
@Component
@EnableScheduling
public class DBUtils {

    @Value("${api.access.key}")
    private String accessKey;

    @Value("${api.currency.pair}")
    private String currencyPair;

    @Value("${api.default.timeZone}")
    private String timeZone;

    @Autowired
    private CurrencyService service;

    @Scheduled(fixedDelay = 60000, initialDelay = 60000)
    @PostConstruct
    public void update() throws UnirestException, JsonProcessingException {
        HttpResponse<JsonNode> response = Unirest.get("https://api.twelvedata.com/time_series?interval=1min")
                .header("accept", "application/json")
                .queryString("symbol", currencyPair)
                .queryString("format", "JSON")
                .queryString("apikey", accessKey)
                .queryString("timezone", timeZone)
                .asJson();
        List<PriceCurrency> allCandles = getCandlesFrom(response);
        allCandles.forEach(c -> service.save(c));
        log.info("API call successful: database updated ");
    }

    private List<PriceCurrency> getCandlesFrom(HttpResponse<com.mashape.unirest.http.JsonNode> response) throws JsonProcessingException {
        JSONArray jsonArray = getJsonArrayFrom(response);
        return mapToList(jsonArray);
    }

    private JSONArray getJsonArrayFrom(HttpResponse<com.mashape.unirest.http.JsonNode> response) {
        log.info("extracting price candles from API response");
        return (JSONArray) response.getBody().getObject().get("values");
    }

    private List<PriceCurrency> mapToList(JSONArray jsonArray) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonArray.toString(), new TypeReference<List<PriceCurrency>>() {
        });
    }
}

