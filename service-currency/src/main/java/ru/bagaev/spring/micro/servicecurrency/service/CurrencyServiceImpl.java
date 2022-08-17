package ru.bagaev.spring.micro.servicecurrency.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bagaev.spring.micro.servicecurrency.generator.GeneratorCurrency;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final GeneratorCurrency generator;

    @Override
    public List<PriceCurrency> getByPair(String name) {
        generator.generateValues();
        return generator.getCurrPairs().get(name);
    }
}
