package com.alura.forohub_challenge.domain.Topic;

import java.time.LocalDateTime;


public record DataCreateTopic(
        String title,
        String message,
        LocalDateTime date,
        StatusTopic status,
        Long idCourse,
        Long idUser) {
}

