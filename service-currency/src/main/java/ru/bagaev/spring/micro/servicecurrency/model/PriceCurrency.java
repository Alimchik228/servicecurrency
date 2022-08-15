package ru.bagaev.spring.micro.servicecurrency.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PriceCurrency {
    private String datetime;
    private double close;
}