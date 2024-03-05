package com.kimchipremium.kimchipremium.dto;

import lombok.Data;

import java.util.List;

@Data
public class BinanceMarketsResponse {
    private List<BinanceSymbol> symbols;

    @Data
    private static class BinanceSymbol {
        private String symbol;
        private String status;
        private String baseAsset;
        private String quoteAsset;
    }
}
