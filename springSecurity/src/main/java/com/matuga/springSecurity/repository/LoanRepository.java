package com.matuga.springSecurity.repository;

import com.matuga.springSecurity.model.Loans;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

  @PreAuthorize("hasRole('ADMIN')")
  List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
