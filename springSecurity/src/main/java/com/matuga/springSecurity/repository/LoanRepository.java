package com.matuga.springSecurity.repository;

import com.matuga.springSecurity.model.Loans;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

  List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
