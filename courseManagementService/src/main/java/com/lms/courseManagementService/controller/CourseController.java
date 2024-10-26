package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.dto.CourseDTO;
import com.lms.courseManagementService.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@Validated @RequestBody CourseDTO courseRequest) {
        return ResponseEntity.ok(courseService.save(courseRequest));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ResponseEntity<List<CourseDTO>> getAllCourse() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @PutMapping()
    public ResponseEntity<CourseDTO> updateCourse(
            @Validated @RequestBody CourseDTO courseRequest
    ) {
        return ResponseEntity.ok(courseService.update(courseRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
