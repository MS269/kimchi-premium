package com.kimchipremium.kimchipremium.dto;

import lombok.Data;

@Data
public class BinanceTickerResponse {
    private String symbol;
    private double price;
}
