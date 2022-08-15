package ru.bagaev.spring.micro.servicepricehistory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  MyController {

    @GetMapping("/hello")
    public String getString() {
        return "helloworld";
    }
}
