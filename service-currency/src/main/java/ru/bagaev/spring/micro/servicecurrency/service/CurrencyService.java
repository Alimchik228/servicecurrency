package ru.bagaev.spring.micro.servicecurrency.service;

import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;

import java.util.List;


public interface CurrencyService {

    List<PriceCurrency> getByPair(String name);
}
