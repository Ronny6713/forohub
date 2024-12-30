package com.alura.forohub_challenge.domain.Course;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void deleteCourse(Long id) {
        Optional<Course> optionalcourse = courseRepository.findById(id);
        if (!optionalcourse.isPresent()) {
            throw new ValidationExceptionApi("El Id ingresado no existe");
        }
        Course course = optionalcourse.get();
        course.disableCourse();
    }
}
