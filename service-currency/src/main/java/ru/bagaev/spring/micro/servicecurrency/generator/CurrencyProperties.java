package ru.bagaev.spring.micro.servicecurrency.generator;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="app")
@NoArgsConstructor
@Data
public class CurrencyProperties {

    List<PairCurr> pairList;
    @Data
    @NoArgsConstructor
    public static class PairCurr {
        private String name;
        private Double price;
    }

}
