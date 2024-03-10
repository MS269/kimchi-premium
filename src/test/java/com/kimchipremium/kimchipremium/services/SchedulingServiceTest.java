package com.kimchipremium.kimchipremium.services;

import com.kimchipremium.kimchipremium.models.Exchange;
import com.kimchipremium.kimchipremium.repositories.ExchangeRepository;
import com.kimchipremium.kimchipremium.repositories.MarketRepository;
import com.kimchipremium.kimchipremium.repositories.TickerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class SchedulingServiceTest {

    @Autowired
    SchedulingService schedulingService;
    @Autowired
    ExchangeRepository exchangeRepository;
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    TickerRepository tickerRepository;

    @Test
    void addExchanges() {
        // given
        String[] exchangeNames = {"Upbit", "Binance"};

        // when
        schedulingService.addExchanges(exchangeNames);

        // then
        Arrays.stream(exchangeNames)
                .forEach(exchangeName -> {
                    Optional<Exchange> exchangeOpt = exchangeRepository.findByName(exchangeName);

                    assertTrue(exchangeOpt.isPresent());
                    assertEquals(exchangeOpt.get().getName(), exchangeName);
                });
    }

    @Test
    void addMarkets() {
    }

    @Test
    void addTickers() {
    }
}