package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.dto.LessonDTO;
import com.lms.courseManagementService.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<LessonDTO>> getAll() {
        return ResponseEntity.ok(lessonService.getAll());
    }

    @PutMapping()
    public ResponseEntity<LessonDTO> updateLesson(
            @Validated @RequestBody LessonDTO lessonRequest
    ) {
        return ResponseEntity.ok(lessonService.update(lessonRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
