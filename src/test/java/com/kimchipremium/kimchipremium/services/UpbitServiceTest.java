package com.kimchipremium.kimchipremium.services;

import com.kimchipremium.kimchipremium.dto.UpbitMarketResponse;
import com.kimchipremium.kimchipremium.dto.UpbitTickerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class UpbitServiceTest {

    UpbitService upbitService;

    @BeforeEach
    void beforeEach() {
        upbitService = new UpbitService();
    }

    @Test
    void fetchMarkets() {
        // given
        // when
        UpbitMarketResponse[] result = upbitService.fetchMarkets();

        // then
        assertNotNull(result);
    }

    @Test
    void fetchTickers() {
        // given
        String[] markets = {"KRW-BTC", "KRW-ETH"};

        // when
        UpbitTickerResponse[] result = upbitService.fetchTickers(markets);

        // then
        assertNotNull(result);
        assertEquals(result.length, markets.length);
        IntStream.range(0, markets.length).forEach(i -> assertEquals(result[i].getMarket(), markets[i]));
    }

}