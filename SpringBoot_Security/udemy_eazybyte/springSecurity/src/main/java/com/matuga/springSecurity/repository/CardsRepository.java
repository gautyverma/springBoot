package com.matuga.springSecurity.repository;

import com.matuga.springSecurity.model.Cards;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {

  List<Cards> findByCustomerId(int customerId);
}
