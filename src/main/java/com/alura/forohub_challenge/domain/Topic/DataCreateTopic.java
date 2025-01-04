package com.alura.forohub_challenge.domain.Topic;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


public record DataCreateTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
        LocalDateTime date,
        StatusTopic status,
        @NotNull
        Long idCourse,
        @Nonnull
        Long idUser) {
}

