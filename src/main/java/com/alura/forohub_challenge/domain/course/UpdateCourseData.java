package com.alura.forohub_challenge.domain.course;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public record UpdateCourseData(
        @Nonnull
        Long id,
        @NotBlank
        String nameCourse,
        @NotBlank
        String description) {
}
