package com.matuga.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
  @GetMapping("/myCards")
  public String getAccountDetails() {
    return "here the card details from DB.";
  }
}
