package com.matuga.springSecurity.config;

import com.matuga.springSecurity.model.Customer;
import com.matuga.springSecurity.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BankUserDetails implements UserDetailsService {

  @Autowired CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String usernName, password = null;
    List<GrantedAuthority> authorities = null;
    List<Customer> customer = customerRepository.findByEmail(username);
    if (customer.size() == 0) {
      throw new UsernameNotFoundException(" User details are not found for the user: " + username);
    } else {
      usernName = customer.get(0).getEmail();
      password = customer.get(0).getPwd();
      authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
    }
    return new User(username, password, authorities);
  }
}
