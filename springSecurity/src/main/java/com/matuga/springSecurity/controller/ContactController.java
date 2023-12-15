package com.matuga.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
  @GetMapping("/contact")
  public String getAccountDetails() {
    return "Inquiry details are saved to DB.";
  }
}
