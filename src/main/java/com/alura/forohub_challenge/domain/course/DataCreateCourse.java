package com.alura.forohub_challenge.domain.course;

import jakarta.validation.constraints.NotBlank;

public record DataCreateCourse(
        @NotBlank
        String nameCourse,
        @NotBlank
        String description) {
}
