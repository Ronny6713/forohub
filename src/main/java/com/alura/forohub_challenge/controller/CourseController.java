package com.alura.forohub_challenge.controller;

import com.alura.forohub_challenge.domain.Course.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;

    //Create course
    @PostMapping
    @Transactional
    public ResponseEntity createCourse(@RequestBody @Valid DataCourse dataCourse) {
        Course course = courseRepository.save(new Course(dataCourse));
        return ResponseEntity.ok(dataCourse);
    }
    //All course
    @GetMapping
    public ResponseEntity<Page<DataCourse>> listCourse(@PageableDefault(size = 10, sort = "nameCourse") Pageable pageable) {
        return ResponseEntity.ok(courseRepository.findByVisibleTrue(pageable).map(DataCourse::new));
    }

    //All courses mode Admin
    @GetMapping("/admin")
    public ResponseEntity <Page<DataCourse>> allCourse(@PageableDefault(size = 10, sort = "nameCourse")Pageable pageable) {
        return ResponseEntity.ok(courseRepository.findAll(pageable).map(DataCourse::new));
    }

    //List of id
    @GetMapping("/{id}")
    public ResponseEntity listCourse(@PathVariable Long id) {
        Optional<Course> course = courseRepository.findById(id);
        var dataCourse = new DataCourse(course.get().getNameCourse(), course.get().getDescription());
        return ResponseEntity.ok(dataCourse);
    }

    //Update Course
    @PutMapping
    @Transactional
    public ResponseEntity updateCourse(@RequestBody @Valid DataUpdateCourse dataUpdateCourse) {
        Course course = courseRepository.getReferenceById(dataUpdateCourse.id());
        course.updateCourse(dataUpdateCourse);
        return ResponseEntity.ok(dataUpdateCourse);
    }

    //Delete Course
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
