package br.com.javadevweek.smartdelivery.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Ser gerenciada pelo Spring
@EnableWebSecurity// Bean => Toda classe gerenciada pelo spring
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/customers/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/products/").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }
}
