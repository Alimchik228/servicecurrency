package ru.bagaev.spring.micro.servicecurrency.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;
import ru.bagaev.spring.micro.servicecurrency.repository.CurrencyRepository;

import java.util.List;

@Service
@Slf4j
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<PriceCurrency> getAll() {
        return currencyRepository.getAll();
    }

    public void save(PriceCurrency priceCandle) {
        currencyRepository.save(priceCandle);
    }
}
