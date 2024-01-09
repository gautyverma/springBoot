package com.matuga.springSecurity.controller;

import com.matuga.springSecurity.model.Loans;
import com.matuga.springSecurity.repository.LoanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

  @Autowired private LoanRepository loanRepository;

  @GetMapping("/myLoans")
  //  @PostAuthorize("hasRole('ROOT')")
  public List<Loans> getLoanDetails(@RequestParam int id) {
    List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    if (loans != null) {
      return loans;
    } else {
      return null;
    }
  }
}
