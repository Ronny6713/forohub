package com.alura.forohub_challenge.domain.Topic;


import java.time.LocalDateTime;

public record DataTopic(
        String title,
        String message,
        LocalDateTime date,
        StatusTopic status,
        Long idCourse,
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
