package com.matuga.springsecOAUTH2GitHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTH2GitHubConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
        .oauth2Login(Customizer.withDefaults());
    return http.build();
  }

  /*
    @Bean
    public ClientRegistrationRepository clientRepository() {
      ClientRegistration clientReg = clientRegistration();
      return new InMemoryClientRegistrationRepository(clientReg);
    }

    private ClientRegistration clientRegistration() {
      return CommonOAuth2Provider.GITHUB
          .getBuilder("github")
          .clientId("35bf3f515f95c6b7f422")
          .clientSecret("b97ffd64331fd4602af064d6b18c4eaee20375c3")
          .build();
    }
  */
}
