package com.devsuperior.aula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desativa o CSRF (importante para permitir POST/PUT/DELETE via Postman)
            .csrf(csrf -> csrf.disable())

            // Libera tudo — nenhuma autenticação exigida
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // Desativa qualquer tipo de login automático
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
