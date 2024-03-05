package com.kimchipremium.kimchipremium.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpbitTickerResponse {
    private String market;
    private double trade_price;
    private Date timestamp;
}
