package com.kimchipremium.kimchipremium.dto;

import lombok.Data;

import java.util.Map;

@Data
public class UpbitMarketResponse {
    private String market;
    private String korean_name;
    private String english_name;
    private UpbitMarketEvent market_event;

    @Data
    private static class UpbitMarketEvent {
        private boolean warning;
        private Map<String, Boolean> caution;
    }
}
