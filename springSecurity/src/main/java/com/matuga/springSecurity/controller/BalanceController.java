package com.matuga.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
  @GetMapping("/myBalance")
  public String getAccountDetails() {
    return "here the balance details from DB.";
  }
}
