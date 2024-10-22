package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.dto.LessonDTO;
import com.lms.courseManagementService.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
@AllArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDTO> createLesson(@Validated @RequestBody LessonDTO lessonRequest) {
        return ResponseEntity.ok(lessonService.save(lessonRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getLesson(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonDTO> updateLesson(
            @PathVariable Long id,
            @Validated @RequestBody LessonDTO lessonRequest
    ) {
        return ResponseEntity.ok(lessonService.update(id, lessonRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
