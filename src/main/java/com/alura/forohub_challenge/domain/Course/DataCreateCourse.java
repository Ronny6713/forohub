package com.alura.forohub_challenge.domain.Course;

import jakarta.validation.constraints.NotBlank;

public record DataCreateCourse(
        @NotBlank
        String nameCourse,
        @NotBlank
        String description) {
}
