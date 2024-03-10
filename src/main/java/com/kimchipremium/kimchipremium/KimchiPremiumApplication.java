package com.kimchipremium.kimchipremium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KimchiPremiumApplication {

    public static void main(String[] args) {
        SpringApplication.run(KimchiPremiumApplication.class, args);
    }

}
