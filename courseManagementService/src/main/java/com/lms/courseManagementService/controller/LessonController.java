package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.service.LessonService;
import com.lms.courseManagementService.model.dto.request.LessonRequest;
import com.lms.courseManagementService.model.dto.response.LessonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonResponse> createLesson(@Validated @RequestBody LessonRequest lessonRequest) {
        return ResponseEntity.ok(lessonService.save(lessonRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getLesson(@PathVariable UUID id) {
        return ResponseEntity.ok(lessonService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> updateLesson(
            @PathVariable UUID id,
            @Validated @RequestBody LessonRequest lessonRequest
    ) {
        return ResponseEntity.ok(lessonService.update(id, lessonRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable UUID id) {
        lessonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
