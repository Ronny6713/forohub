package com.alura.forohub_challenge.user;

import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.domain.Topic.StatusTopic;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


@JsonIgnoreProperties
public record UserTopicData(
        String title,
        String date,
        StatusTopic status,
        @JsonAlias("nameCourse")
        String Course,
        @JsonAlias("username")
        String Author) {

}
