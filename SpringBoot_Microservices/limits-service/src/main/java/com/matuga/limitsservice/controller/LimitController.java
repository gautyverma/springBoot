package com.matuga.limitsservice.controller;

import com.matuga.limitsservice.configuration.Configuration;
import com.matuga.limitsservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

  @Autowired private Configuration configuration;

  @GetMapping("/limits")
  public Limits retrieveLimit() {
    //    return new Limits(1, 1000);
    return new Limits(
        configuration.getMinimum(),
        configuration.getMaximum()); // Get Value from application.properties
  }
}
