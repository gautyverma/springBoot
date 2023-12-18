package com.matuga.springSecurity.config;

import com.matuga.springSecurity.filter.CsrfCookieFliter;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfiguration {
  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    /*
     * Below are the custom security configuration
     * */

    CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
    requestHandler.setCsrfRequestAttributeName("_csrf");

    http.securityContext()
        .requireExplicitSave(false)
        .and()
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).
    cors()
        .configurationSource(
            new CorsConfigurationSource() {
              @Override
              public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(3600L);
                return config;
              }
            })
        .and()
        .csrf(
            (csrf) ->
                csrf.csrfTokenRequestHandler(requestHandler)
                    .ignoringRequestMatchers("/contact", "/register")
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .addFilterAfter(new CsrfCookieFliter(), BasicAuthenticationFilter.class)
        .authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers("/welcome", "/myAccount", "/myBalance", "/myCards", "/myLoans")
                    .authenticated()
                    .requestMatchers("/contact", "/notices", "/register")
                    .permitAll());
    http.formLogin(Customizer.withDefaults());
    http.httpBasic(Customizer.withDefaults());
    return http.build();

    /*
    * Configuration to deny all requests
    // http.authorizeHttpRequests((request)->request.anyRequest().denyAll());
    * */

    /*
    * Configuration to permit all requests
    // http.authorizeHttpRequests((request)->request.anyRequest().permitAll());
    * */
  }

  /*
  // Using InMemoryUserDetailsManager
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    */
  /*
   * Approach 1 - Where we use withDefaultPasswordEncoder() method while creating the user details.
   * */
  /*


  */
  /*
  UserDetails admin =
      User.withDefaultPasswordEncoder()
          .username("admin")
          .password("123")
          .authorities("admin")
          .build();
  UserDetails user =
      User.withDefaultPasswordEncoder()
          .username("user")
          .password("123")
          .authorities("read")
          .build();
  return new InMemoryUserDetailsManager(admin,user);
  */
  /*


  */
  /*
   * Approach 2 - Where we use "NoOpPasswordEncoder" Bean while creating the user details.
   * */
  /*

      UserDetails admin = User.withUsername("admin").password("123").authorities("admin").build();
      UserDetails user = User.withUsername("user").password("123").authorities("read").build();
      return new InMemoryUserDetailsManager(admin, user);
    }

  */

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /*
  // It fetch the value users table - mentioned in script.sql
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
      return new JdbcUserDetailsManager(dataSource);
    }
  */
}
