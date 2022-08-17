package ru.bagaev.spring.micro.servicecurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.bagaev.spring.micro.servicecurrency.generator.CurrencyProperties;
import ru.bagaev.spring.micro.servicecurrency.generator.GeneratorCurrency;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;
import ru.bagaev.spring.micro.servicecurrency.service.CurrencyService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ServiceCurrencyTests {

    @Autowired
    CurrencyProperties currencyProperties;


    @Test
    void testYAMLConfig(){

        Assertions.assertEquals("EUR/USD", currencyProperties.getPairList().get(0).getName());
        Assertions.assertEquals(1.0174, currencyProperties.getPairList().get(0).getPrice());
        Assertions.assertEquals(3, currencyProperties.getPairList().size());

    }


}
