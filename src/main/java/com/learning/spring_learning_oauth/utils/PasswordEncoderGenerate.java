package com.learning.spring_learning_oauth.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerate {
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    };
}
