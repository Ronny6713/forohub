package com.alura.forohub_challenge.domain.Course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record DataCourse(
        String nameCourse,
        String description) {

        public DataCourse(Course course) {
            this(course.getNameCourse(), course.getDescription());
        }
}
