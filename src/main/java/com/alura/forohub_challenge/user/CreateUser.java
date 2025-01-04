package com.alura.forohub_challenge.user;

import jakarta.validation.constraints.NotBlank;

public record CreateUser(
        @NotBlank
        String username,
        @NotBlank
        String password) {
}
