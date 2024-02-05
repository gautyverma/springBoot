package com.matuga.microservice.currencyconversionservice.util;

import com.matuga.microservice.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
@FeignClient(
    name = "currency-exchange",
    url = "localhost:8000") // mostly we give the name of the service
*/
@FeignClient(name = "currency-exchange") // this will call the naming-server to get up instance
public interface CurrencyExchangeProxy {
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyConversion retrieveExchangeValue(
      @PathVariable String from, @PathVariable String to);
}
