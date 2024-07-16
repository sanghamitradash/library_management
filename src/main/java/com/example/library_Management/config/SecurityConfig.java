package com.example.library_Management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                        .requestMatchers(HttpMethod.POST,"/api/library/registerUser").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/library/addBook").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/library/login").permitAll()
                                .anyRequest().authenticated()
                );

        //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //Disable Cross Site Request Forgery
        //in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
 