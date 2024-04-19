package me.symi.carshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/uploadImage").permitAll()
                        //.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        //.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
        );


        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
