package com.alura.forohub_challenge.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record UpdateTopicData(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
        LocalDateTime date,
        StatusTopic status,
        Long idCourse,
        @NotNull
        Long idUser) {
}
