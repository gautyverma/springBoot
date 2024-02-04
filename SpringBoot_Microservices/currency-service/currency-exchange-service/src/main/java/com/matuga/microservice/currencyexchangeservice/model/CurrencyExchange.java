package com.matuga.microservice.currencyexchangeservice.model;

import java.math.BigDecimal;

public class CurrencyExchange {
  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionMultiple;
  private String envPort;

  public CurrencyExchange() {}

  public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public String getEnvPort() {
    return envPort;
  }

  public void setEnvPort(String envPort) {
    this.envPort = envPort;
  }
}
