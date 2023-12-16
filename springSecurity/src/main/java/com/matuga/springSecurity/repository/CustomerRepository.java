package com.matuga.springSecurity.repository;

import com.matuga.springSecurity.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByEmail(String email);
}
