package com.alura.forohub_challenge.domain.validation.courseValidation.updateCourse;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.course.CourseRepository;
import com.alura.forohub_challenge.domain.course.UpdateCourseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseUpdateValidation implements IValidationUpdateCourse {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void validation(UpdateCourseData updateCourseData) {
        boolean courseExist = courseRepository.existsById(updateCourseData.id());
        if (!courseExist) {
            throw new ValidationExceptionApi("The course ID you want to update does not exist.");
        }
        var validationNamecourse =  updateCourseData.nameCourse().trim().toLowerCase();
        var validationDescription = updateCourseData.description().trim().toLowerCase();
        boolean nameCourseVerification = courseRepository.existsByNameCourse(validationNamecourse);
        boolean descriptionVerification = courseRepository.existsByDescription(validationDescription);
        if (nameCourseVerification) {
            throw new ValidationExceptionApi("There's already a course with this name.");
        } else if (descriptionVerification) {
            throw new ValidationExceptionApi("There's already a course with this description.");
        }
    }
}
