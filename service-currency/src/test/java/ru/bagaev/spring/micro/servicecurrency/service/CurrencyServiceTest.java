package ru.bagaev.spring.micro.servicecurrency.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bagaev.spring.micro.servicecurrency.generator.GeneratorCurrency;

@AutoConfigureMockMvc
@SpringBootTest
public class CurrencyServiceTest {

    @Autowired
    GeneratorCurrency generatorCurrency;

    @Autowired
    CurrencyService currencyService;

    @Test
    void testService(){

        generatorCurrency.generateValues();
        Assertions.assertNotNull(currencyService.getByPair("USD/RUB"));

    }
}
