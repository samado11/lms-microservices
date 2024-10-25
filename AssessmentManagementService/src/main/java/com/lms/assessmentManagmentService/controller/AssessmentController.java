package com.lms.assessmentManagmentService.controller;

import com.lms.assessmentManagmentService.dto.AssessmentDTO;
import com.lms.assessmentManagmentService.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assessments")
@RequiredArgsConstructor
public class AssessmentController {
    private final AssessmentService assessmentService;

    @PostMapping
    public ResponseEntity<AssessmentDTO> createAssessment(@Validated @RequestBody AssessmentDTO assessmentRequest) {
        return ResponseEntity.ok(assessmentService.save(assessmentRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssessmentDTO> getAssessmentById(@PathVariable Long id) {
        return ResponseEntity.ok(assessmentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssessmentDTO> updateAssessment(
            @PathVariable Long id,
            @Validated @RequestBody AssessmentDTO assessmentRequest
    ) {
        return ResponseEntity.ok(assessmentService.update(id, assessmentRequest));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAssessmentById(@PathVariable Long id) {
        assessmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
