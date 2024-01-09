package com.matuga.springSecurity.controller;

import com.matuga.springSecurity.model.Cards;
import com.matuga.springSecurity.repository.CardsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

  @Autowired private CardsRepository cardsRepository;

  @GetMapping("/myCards")
  public List<Cards> getCardDetails(@RequestParam int id) {
    List<Cards> cards = cardsRepository.findByCustomerId(id);
    if (cards != null) {
      return cards;
    } else {
      return null;
    }
  }
}
