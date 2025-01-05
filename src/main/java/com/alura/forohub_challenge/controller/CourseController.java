package com.alura.forohub_challenge.controller;

import com.alura.forohub_challenge.domain.course.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ServiceCourse serviceCourse;

    //Create course
    @PostMapping
    @Transactional
    public ResponseEntity createCourse(@RequestBody @Valid DataCreateCourse dataCreateCourse) {
        serviceCourse.createCourse(dataCreateCourse);
        return ResponseEntity.ok(dataCreateCourse);
    }
    //All course
    @GetMapping
    public ResponseEntity<Page<DataCourse>> listCourse(@PageableDefault(size = 10, sort = "nameCourse") Pageable pageable) {
        return ResponseEntity.ok(courseRepository.findByVisibleTrue(pageable).map(DataCourse::new));
    }

    //All courses mode Admin
    @GetMapping("/admin/allcourses")
    public ResponseEntity <Page<DataCourse>> allCourse(@PageableDefault(size = 10, sort = "nameCourse")Pageable pageable) {
        return ResponseEntity.ok(courseRepository.findAll(pageable).map(DataCourse::new));
    }

    //List of id
    @GetMapping("/{id}")
    public ResponseEntity listCourseId(@PathVariable Long id) {
        var course = serviceCourse.courseId(id);
        return ResponseEntity.ok(course);
    }

    //Update Course
    @PutMapping
    @Transactional
    public ResponseEntity updateCourse(@RequestBody @Valid UpdateCourseData updateCourseData) {
        var course = serviceCourse.updateCourse(updateCourseData);
        return ResponseEntity.ok(course);
    }

    //Delete Course
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        serviceCourse.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
