package com.matuga.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
  @GetMapping("/notices")
  public String getAccountDetails() {
    return "Here the notice details from DB.";
  }
}
