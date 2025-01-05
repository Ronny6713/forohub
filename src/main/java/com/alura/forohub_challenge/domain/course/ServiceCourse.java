package com.alura.forohub_challenge.domain.course;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.validation.courseValidation.createCourse.IValidationsCreateCourse;
import com.alura.forohub_challenge.domain.validation.courseValidation.updateCourse.IValidationUpdateCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCourse {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private List<IValidationsCreateCourse> validationsCreate;
    @Autowired
    private List<IValidationUpdateCourse> validationUpdates;


    public DataCourse createCourse(DataCreateCourse dataCreateCourse) {
        validationsCreate.forEach(v -> v.validation(dataCreateCourse));
        var course = new Course(dataCreateCourse);
        courseRepository.save(course);
        return new DataCourse(course);
    }

    public DataCourse courseId(Long id) {
        Optional<Course> courseExist = courseRepository.findById(id);
        if (courseExist.isPresent()) {
            throw new ValidationExceptionApi("the course does not exist.");
        }
        DataCourse dataCourse = new DataCourse(courseExist.get());
        return dataCourse;
    }

    public DataCourse updateCourse(UpdateCourseData updateCourseData) {
        validationUpdates.forEach(v -> v.validation(updateCourseData));
        Course course = courseRepository.getReferenceById(updateCourseData.id());
        course.updateCourse(updateCourseData);
        return new DataCourse(course);
    }

    public void deleteCourse(Long id) {
        Optional<Course> optionalcourse = courseRepository.findById(id);
        if (!optionalcourse.isPresent()) {
            throw new ValidationExceptionApi("The entered ID does not exist.");
        }
        Course course = optionalcourse.get();
        course.disableCourse();
    }
}
