package com.alura.forohub_challenge.domain.Course;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCourse {
    @Autowired
    private CourseRepository courseRepository;

    public DataCourse createCourse(DataCreateCourse dataCreateCourse) {
        var nameCourse = dataCreateCourse.nameCourse().trim().toLowerCase();
        var description= dataCreateCourse.description().trim().toLowerCase();
        boolean courseVerificacion = courseRepository.existsByNameCourseAndDescription(nameCourse, description);
        if (courseVerificacion) {
            throw new ValidationExceptionApi("The course already exists.");
        }
        var course = new Course(dataCreateCourse);
        courseRepository.save(course);
        return new DataCourse(course);
    }

    public DataCourse courseId(Long id) {
        boolean courseExist = courseRepository.existsById(id);
        if (!courseExist) {
            throw new ValidationExceptionApi("the course does not exist.");
        }
        var course = courseRepository.getReferenceById(id);
        DataCourse dataCourse = new DataCourse(course);
        return dataCourse;
    }

    public DataCourse updateCourse(UpdateCourseData updateCourseData) {
        boolean courseExist = courseRepository.existsById(updateCourseData.id());
        if (!courseExist) {
            throw new ValidationExceptionApi("The course ID you want to update does not exist.");
        }
        Course course = courseRepository.getReferenceById(updateCourseData.id());
        course.updateCourse(updateCourseData);
        DataCourse dataCourse = new DataCourse(course);
        return dataCourse;
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
