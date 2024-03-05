package com.kimchipremium.kimchipremium.services;

import com.kimchipremium.kimchipremium.dto.UpbitMarketResponse;
import com.kimchipremium.kimchipremium.dto.UpbitTickerResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * <a href="https://binance-docs.github.io/apidocs/spot/en">API Reference</a>
 */
@Service
public class UpbitService {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://api.upbit.com/v1")
            .build();

    public UpbitMarketResponse[] fetchMarkets() {
        return restClient.get()
                .uri("/market/all?isDetails=true")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(UpbitMarketResponse[].class);
    }

    public UpbitTickerResponse[] fetchTickers(String[] markets) {
        return restClient.get()
                .uri("/ticker?markets={markets}", String.join(", ", markets))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(UpbitTickerResponse[].class);
    }
}
