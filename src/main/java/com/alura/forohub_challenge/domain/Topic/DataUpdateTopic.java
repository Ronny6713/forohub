package com.alura.forohub_challenge.domain.Topic;

import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.user.User;

import java.time.LocalDateTime;

public record DataUpdateTopic(
        Long id,
        String title,
        String message,
        LocalDateTime date,
        StatusTopic status,
        Long idCourse,
                             Long idUser) {
}
