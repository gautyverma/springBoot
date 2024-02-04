package com.matuga.limitsservice.controller;

import com.matuga.limitsservice.model.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

  @GetMapping("/limits")
  public Limits retrieveLimit() {
    return new Limits(1, 1000);
  }
}
