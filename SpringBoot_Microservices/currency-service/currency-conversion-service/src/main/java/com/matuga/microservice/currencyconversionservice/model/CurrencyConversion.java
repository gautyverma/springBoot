package com.matuga.microservice.currencyconversionservice.model;

import java.math.BigDecimal;

public class CurrencyConversion {
  private Long id;
  private String from;
  private String to;
  private BigDecimal quantity;
  private BigDecimal conversionMultiple;

  private BigDecimal totalCalculatedAmount;
  private String envPort;

  public CurrencyConversion() {}

  public CurrencyConversion(
      Long id,
      String from,
      String to,
      BigDecimal quantity,
      BigDecimal conversionMultiple,
      BigDecimal totalCalculatedAmount,
      String envPort) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
    this.quantity = quantity;
    this.totalCalculatedAmount = totalCalculatedAmount;
    this.envPort = envPort;
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

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getTotalCalculatedAmount() {
    return totalCalculatedAmount;
  }

  public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
    this.totalCalculatedAmount = totalCalculatedAmount;
  }

  public String getEnvPort() {
    return envPort;
  }

  public void setEnvPort(String envPort) {
    this.envPort = envPort;
  }
}
