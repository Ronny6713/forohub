package com.alura.forohub_challenge.user;


import com.alura.forohub_challenge.domain.Topic.StatusTopic;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



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
