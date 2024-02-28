package com.example.demokorneuev.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
  @Bean
  PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.authorizeHttpRequests((request)->request.requestMatchers("/registration").permitAll().anyRequest().authenticated())
        .formLogin((form)->form.loginPage("/login").defaultSuccessUrl("/all").permitAll()).logout((logout)->logout.permitAll());
    return http.build();
  }
}
