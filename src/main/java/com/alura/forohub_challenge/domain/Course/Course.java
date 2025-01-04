package com.alura.forohub_challenge.domain.Course;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


@Table(name = "course")
@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nameCourse;

    @NotBlank
    private String description;

    private boolean visible =  true;

    public Course(@Valid DataCourse dataCourse) {
        this.nameCourse = dataCourse.nameCourse();
        this.description = dataCourse.description();
    }

    public Course() {
    }

    public Course(DataCreateCourse dataCreateCourse) {
        this.nameCourse = dataCreateCourse.nameCourse();
        this.description = dataCreateCourse.description();
    }

    public @NotBlank String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(@NotBlank String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /////constructor


    public Course(Long id, boolean visible, String description, String nameCourse) {
        this.id = id;
        this.visible = visible;
        this.description = description;
        this.nameCourse = nameCourse;
    }

    public Course(Long id, String nameCourse, String description, boolean visible) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.description = description;
        this.visible = visible;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void disableCourse() {
        this.visible = false;
    }

    public void updateCourse(@Valid UpdateCourseData updateCourseData) {
        if (updateCourseData.nameCourse() != null) {
            this.nameCourse = updateCourseData.nameCourse();
        }
        if (updateCourseData.description() != null) {
            this.description = updateCourseData.description();
        }
    }
}