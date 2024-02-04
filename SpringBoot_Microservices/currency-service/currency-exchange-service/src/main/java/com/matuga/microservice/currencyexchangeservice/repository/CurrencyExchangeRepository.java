package com.matuga.microservice.currencyexchangeservice.repository;

import com.matuga.microservice.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
  CurrencyExchange findByFromAndTo(String from, String to);
}
