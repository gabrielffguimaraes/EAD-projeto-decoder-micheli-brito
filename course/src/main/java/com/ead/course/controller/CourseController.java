package com.ead.course.controller;

import com.ead.course.repository.CourseRepository;
import com.ead.course.repository.ModuleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Cursos",description = "Endpoint responsável por manter cursos")
@RestController
@RequestMapping("api/course")
public class CourseController {
    private final CourseRepository courseRepository;
    private final ModuleRepository moduleRepository;

    public CourseController(CourseRepository courseRepository, ModuleRepository moduleRepository) {
        this.courseRepository = courseRepository;
        this.moduleRepository = moduleRepository;
    }

    @Operation(summary = "Listar cursos .")
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(this.courseRepository.findAll());
    }
}
