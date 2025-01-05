package com.alura.forohub_challenge.domain.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByVisibleTrue(Pageable pageable);

    boolean existsByNameCourseAndDescription(String nameCourse, String description);
}
