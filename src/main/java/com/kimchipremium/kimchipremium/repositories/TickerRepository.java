package com.kimchipremium.kimchipremium.repositories;

import com.kimchipremium.kimchipremium.models.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TickerRepository extends JpaRepository<Ticker, Long> {
}
