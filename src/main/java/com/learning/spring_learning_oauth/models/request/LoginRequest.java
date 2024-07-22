package com.learning.spring_learning_oauth.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class LoginRequest {
    @NotBlank
    @NonNull
    private String username;
    @NotBlank
    @NonNull
    private String password;
}
