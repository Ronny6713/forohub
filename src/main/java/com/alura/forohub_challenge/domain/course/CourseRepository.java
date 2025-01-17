package com.alura.forohub_challenge.domain.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByVisibleTrue(Pageable pageable);

    boolean existsByNameCourse(String nameCourse);

    boolean existsByDescription(String description);
}
