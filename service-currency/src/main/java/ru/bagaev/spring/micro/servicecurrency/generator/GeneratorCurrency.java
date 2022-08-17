package ru.bagaev.spring.micro.servicecurrency.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@Getter
@AllArgsConstructor
public class GeneratorCurrency {


    private final CurrencyProperties currencyProperties;

    private final Map<String, List<PriceCurrency>> currPairs = new HashMap<>();

    @Scheduled(fixedDelay = 10000)
    public void generateValues() {
        int k = 0;
        List<PriceCurrency> pairs;

        while (k < currencyProperties.getPairList().size()) {

            currPairs.computeIfAbsent(currencyProperties.getPairList().get(k).getName(), i -> {
                return new LinkedList<>();
            });

            pairs = currPairs.get(currencyProperties.getPairList().get(k).getName());

            PriceCurrency pair = mapToPair(currencyProperties, k);

            if (pairs.size() >= 100) {
                pairs.remove(0);
            }
            pairs.add(pair);
            currPairs.put(currencyProperties.getPairList().get(k).getName(), pairs);
            k++;
        }

    }

    private PriceCurrency mapToPair(CurrencyProperties currencyProperties, int k){

        CurrencyProperties.PairCurr pair = currencyProperties.getPairList().get(k);
        Random random =new Random();
        return PriceCurrency.builder()
                .name(pair.getName())
                .price(pair.getPrice() + func(pair.getPrice()) * random.nextGaussian())
                .datetime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
                .build();
    }

    private Double func(Double price) {
        double value = Math.floor(Math.random() * 100) + 1;

        if (value < 36) {
            return price/(200 +  (Math.random() * 300)); //35%
        } else if (value < 61) {
            return price/(100 +  (Math.random() * 200)); //25%
        } else if (value < 86) {
            return price/(40 +  (Math.random() * 100)); //25%
        } else if (value < 96) {
            return price/(10 +  (Math.random() * 40));//10%
        } else {
            return price/(1 + (Math.random() * 10));//5%
        }
    }


}
