package com.alura.forohub_challenge.domain.Course;

import jakarta.annotation.Nonnull;

public record DataUpdateCourse(
        @Nonnull
        Long id,
        String nameCourse,
        String description) {
}
