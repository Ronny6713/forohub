package com.alura.forohub_challenge.domain.course;

import jakarta.validation.constraints.NotBlank;

public record DataCourse(
        @NotBlank
        String nameCourse,
        @NotBlank
        String description) {

        public DataCourse(Course course) {
            this(course.getNameCourse(), course.getDescription());
        }

}
