package ru.bagaev.spring.micro.servicecurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceCurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCurrencyApplication.class, args);
    }

}
