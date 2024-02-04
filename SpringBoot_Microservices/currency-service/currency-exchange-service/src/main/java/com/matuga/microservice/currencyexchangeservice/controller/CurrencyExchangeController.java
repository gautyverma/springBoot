package com.matuga.microservice.currencyexchangeservice.controller;

import com.matuga.microservice.currencyexchangeservice.model.CurrencyExchange;
import com.matuga.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Autowired private CurrencyExchangeRepository currencyExchangeRepository;
  @Autowired private Environment environment;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyExchange retrieveExchangeValue(
      @PathVariable String from, @PathVariable String to) {
    //     Static - Object declared
    //    CurrencyExchange currencyExchange =
    //        new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));

    // dynamic using h2 DB
    CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
    if (currencyExchange == null) {
      throw new RuntimeException("Unable to find the data" + from + " to " + to);
    }
    String port = environment.getProperty("local.server.port");
    currencyExchange.setEnvPort(port);
    return currencyExchange;
  }
}
