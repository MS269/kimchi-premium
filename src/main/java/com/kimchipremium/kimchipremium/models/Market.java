package com.kimchipremium.kimchipremium.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exchange_id")
    private Exchange exchange;

    @Column(unique = true)
    private String symbol;

    private String baseAsset;

    private String quoteAsset;

}
