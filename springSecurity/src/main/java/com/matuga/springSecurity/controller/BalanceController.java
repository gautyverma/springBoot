package com.matuga.springSecurity.controller;

import com.matuga.springSecurity.model.AccountTransactions;
import com.matuga.springSecurity.repository.AccountTransactionsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

  @Autowired private AccountTransactionsRepository accountTransactionsRepository;

  @GetMapping("/myBalance")
  public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
    List<AccountTransactions> accountTransactions =
        accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
    if (accountTransactions != null) {
      return accountTransactions;
    } else {
      return null;
    }
  }
}
