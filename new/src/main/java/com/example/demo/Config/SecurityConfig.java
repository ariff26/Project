package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (since you are calling APIs from external HTML/JS)
                .csrf(csrf -> csrf.disable())

                // Define which endpoints are public
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/login").authenticated()
                        .anyRequest().permitAll()
                )

                .formLogin(form -> form
                        .loginPage("/login")           // our custom login form URL
                        .loginProcessingUrl("/doLogin") // Spring Security will handle POST here
                        .defaultSuccessUrl("/home", true) // redirect after successful login
                        .permitAll()
                );

        return http.build();
    }
}
