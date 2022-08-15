package ru.bagaev.spring.micro.servicecurrency.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bagaev.spring.micro.servicecurrency.model.PriceCurrency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Slf4j
public class CurrencyRepositoryImpl  implements CurrencyRepository {
    @Value("${api.default.quantity}")
    private int defaultCandlesToShow;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PriceCurrency> getAll() {
        List<PriceCurrency> candlesData = getListOfCandles();
        return getListOfCandles();
    }


    private List<PriceCurrency> getListOfCandles() {
        String sqlQuery = String.format("SELECT TOP %d * FROM currency", defaultCandlesToShow);
        return jdbcTemplate.query(sqlQuery, this::priceCandlesRowMapper);
    }



    @Override
    public void save(PriceCurrency priceCandle) {
        String sqlInsertQuery = "INSERT INTO candles(datetime,close) VALUES(?,?)";
        jdbcTemplate.update(sqlInsertQuery,
                priceCandle.getDatetime(),
                priceCandle.getClose());
    }

    private PriceCurrency priceCandlesRowMapper(ResultSet resultSet, int i) throws SQLException {
        return new PriceCurrency()
                .setDatetime(resultSet.getString("datetime"))
                .setClose(resultSet.getDouble("price"));
    }

}
