package com.alura.forohub_challenge.domain.validation.courseValidation.createCourse;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.course.CourseRepository;
import com.alura.forohub_challenge.domain.course.DataCreateCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseCreationValidation implements IValidationsCreateCourse {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validation(DataCreateCourse dataCreateCourse) {
        var nameCourse = dataCreateCourse.nameCourse().trim().toLowerCase();
        var description = dataCreateCourse.description().trim().toLowerCase();
        boolean nameCourseVerificacion = courseRepository.existsByNameCourse(nameCourse);
        boolean descriptionVerification = courseRepository.existsByDescription(description);
        if (nameCourseVerificacion) {
            throw new ValidationExceptionApi("There's already a course with this name.");
        } else if (descriptionVerification) {
            throw new ValidationExceptionApi("There's already a course with this description.");
        }
    }
}
