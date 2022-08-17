package ru.bagaev.spring.micro.servicecurrency.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;
import ru.bagaev.spring.micro.servicecurrency.service.CurrencyService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/get_currency")
public class CurrencyController {

    CurrencyService service;

    @GetMapping
    public List<PriceCurrency> getAllPriceCurrency(@RequestParam String name) {
        List<PriceCurrency> currencyList = service.getByPair(name);
        if (currencyList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "name not found");
        }
        return currencyList;
    }



}
