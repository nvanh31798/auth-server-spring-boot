package com.learning.spring_learning_oauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .exceptionHandling(exceptions ->
                exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
        )
        .authorizeHttpRequests(requests -> requests
                .requestMatchers("*/**").permitAll()
                .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
