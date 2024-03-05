package com.kimchipremium.kimchipremium.services;

import com.kimchipremium.kimchipremium.dto.BinanceMarketsResponse;
import com.kimchipremium.kimchipremium.dto.BinanceTickerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinanceServiceTest {

    private BinanceService binanceService;

    @BeforeEach
    void beforeEach() {
        binanceService = new BinanceService();
    }

    @Test
    void fetchMarkets() {
        // given
        // when
        BinanceMarketsResponse result = binanceService.fetchMarkets();

        // then
        assertNotNull(result);
    }


    @Test
    void fetchTickers() {
        // given
        String[] markets = {"BTCUSDT", "ETHUSDT"};

        // when
        BinanceTickerResponse[] result = binanceService.fetchTickers(markets);

        // then
        assertNotNull(result);
        assertEquals(result.length, markets.length);
        IntStream.range(0, markets.length).forEach(i -> assertEquals(result[i].getSymbol(), markets[i]));
    }

}