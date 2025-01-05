package com.alura.forohub_challenge.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateUser(
        @NotBlank
        String username,
        @NotBlank
        String password) {
}
