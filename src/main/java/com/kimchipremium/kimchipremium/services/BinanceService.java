package com.kimchipremium.kimchipremium.services;

import com.kimchipremium.kimchipremium.dto.BinanceMarketsResponse;
import com.kimchipremium.kimchipremium.dto.BinanceTickerResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * <a href="https://docs.upbit.com/reference">API Reference</a>
 */
@Service
public class BinanceService {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://api.binance.com/api/v3")
            .build();

    public BinanceMarketsResponse fetchMarkets() {
        return restClient.get()
                .uri("/exchangeInfo")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BinanceMarketsResponse.class);
    }

    public BinanceTickerResponse[] fetchTickers(String[] markets) {
        return restClient.get()
                .uri("/ticker/price?symbols={symbols}", "[\"" + String.join("\",\"", markets) + "\"]")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BinanceTickerResponse[].class);
    }

}
