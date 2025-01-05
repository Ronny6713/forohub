package com.alura.forohub_challenge.domain.topic;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record DataTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
        LocalDateTime date,
        StatusTopic status,
        @NotNull
        Long idCourse,
        @NotNull
        Long idUser){

    public DataTopic(Topic topic) {
        this(topic.getTitle(),
                topic.getMessage(),
                topic.getDate(),
                topic.getStatus(),
                topic.getCourse().getId(),
                topic.getUser().getId());
    }
}
