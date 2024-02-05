package com.matuga.microservice.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
  private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

  @GetMapping("/sample-api")
  //  @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
  @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
  @RateLimiter(name = "default")
  // 10s -> 10000 calls to sample api
  public String sampleApi() {
    logger.info("Sample API call received");
    // Some fail code for retry attempt
    ResponseEntity<String> entity =
        new RestTemplate().getForEntity("http://localhost:8080/dummy-fail", String.class);
    return entity.getBody();
  }

  public String hardcodedResponse(Exception ex) {
    return "fallback-response";
  }
}
