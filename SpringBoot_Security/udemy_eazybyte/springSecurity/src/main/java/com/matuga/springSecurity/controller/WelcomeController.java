package com.matuga.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
  @GetMapping("/welcome")
  public String getAccountDetails() {
    return "Welcome You have decided to start the Spring Security. FINALLY!!";
  }
}
