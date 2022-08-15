package ru.bagaev.spring.micro.servicecurrency.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;
import ru.bagaev.spring.micro.servicecurrency.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    CurrencyService service;

    @GetMapping("/getAll")
    public List<PriceCurrency> getAllPriceCandles() {
        return service.getAll();
    }


}
