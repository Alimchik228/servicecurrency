package ru.bagaev.spring.micro.servicecurrency.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class CurrencyControllerTest {

    @Test
    void testControllerWithMockMvc(@Autowired MockMvc mvc) throws Exception {

        String name = "EUR/USD";
        mvc.perform(get("/api/v1/get_currency")).andExpect(status().isBadRequest());
        mvc.perform(get("/api/v1/get_currency?name=" + name)).andExpect(status().isOk());

    }
}
