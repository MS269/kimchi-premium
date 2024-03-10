package com.kimchipremium.kimchipremium.services;

import com.kimchipremium.kimchipremium.models.Exchange;
import com.kimchipremium.kimchipremium.repositories.ExchangeRepository;
import com.kimchipremium.kimchipremium.repositories.MarketRepository;
import com.kimchipremium.kimchipremium.repositories.TickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchedulingService implements ApplicationRunner {

    private final String[] exchangeNames = {"Upbit", "Binance"};

    private final UpbitService upbitService;
    private final BinanceService binanceService;
    private final ExchangeRepository exchangeRepository;
    private final MarketRepository marketRepository;
    private final TickerRepository tickerRepository;

    @Override
    public void run(ApplicationArguments args) {
        this.addExchanges(exchangeNames);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void runEveryMinutes() {
        this.addMarkets();
        this.addTickers();
    }

    public void addExchanges(String[] exchangeNames) {
        Arrays.stream(exchangeNames)
                .forEach(exchangeName -> {
                    Optional<Exchange> exchangeOpt = this.exchangeRepository.findByName(exchangeName);
                    if (exchangeOpt.isPresent()) {
                        return;
                    }

                    Exchange newExchange = new Exchange();
                    newExchange.setName(exchangeName);

                    this.exchangeRepository.save(newExchange);
                });
    }

    public void addMarkets() {
    }

    public void addTickers() {
    }
}
