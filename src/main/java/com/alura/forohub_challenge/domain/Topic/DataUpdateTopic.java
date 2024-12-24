package com.alura.forohub_challenge.domain.Topic;

import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.user.FinalUser;

import java.time.LocalDateTime;

public record DataUpdateTopic(String title,
                              String message,
                              LocalDateTime date,
                              StatusTopic status,
                              FinalUser username,
                              Course course) {
}
