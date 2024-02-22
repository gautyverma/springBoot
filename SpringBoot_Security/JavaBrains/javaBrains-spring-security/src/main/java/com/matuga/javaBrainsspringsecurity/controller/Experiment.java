package com.matuga.javaBrainsspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Experiment {
  @GetMapping("/exp")
  public String getExp() {
    return "Experiment-Java-Brains";
  }
}
