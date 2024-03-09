package com.kimchipremium.kimchipremium.repositories;

import com.kimchipremium.kimchipremium.models.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Optional<Exchange> findByName(String name);
}
