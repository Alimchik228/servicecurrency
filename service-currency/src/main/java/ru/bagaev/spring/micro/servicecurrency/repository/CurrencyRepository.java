package ru.bagaev.spring.micro.servicecurrency.repository;

import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;

import java.util.List;

public interface CurrencyRepository {
    List<PriceCurrency> getAll();
    void save(PriceCurrency priceCurrency);
}
