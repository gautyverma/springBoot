package com.matuga.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  @GetMapping("/myAccount")
  public String getAccountDetails() {
    return "here the account details from DB.";
  }
}
