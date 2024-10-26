package com.lms.quizAssignmentService.controller;

import com.lms.quizAssignmentService.dto.AssessmentDto;
import com.lms.quizAssignmentService.exception.AssessmentNotFoundException;
import com.lms.quizAssignmentService.response.ApiResponse;
import com.lms.quizAssignmentService.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController

@RequestMapping("/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllAssessments() {
        List<AssessmentDto> allAssessments = assessmentService.getAllAssessments();
        return ResponseEntity.ok(new ApiResponse(allAssessments));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getAssessmentById(@PathVariable Long id) {
        try {
            AssessmentDto assessmentDto = assessmentService.getAssessmentById(id);
            return ResponseEntity.ok(new ApiResponse(assessmentDto));
        } catch (AssessmentNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createAssessment(@RequestBody AssessmentDto assessmentDto) {

        try {
            AssessmentDto createdAssessment = assessmentService.createAssessment(assessmentDto);
            return ResponseEntity.ok(new ApiResponse(createdAssessment));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateAssessment(@PathVariable Long id, @RequestBody AssessmentDto assessmentDto) {
        try {

            AssessmentDto updatedAssessment = assessmentService.updateAssessment(id, assessmentDto);
            return ResponseEntity.ok(new ApiResponse(updatedAssessment));

        } catch (AssessmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAssessment(@PathVariable Long id) {
        try {
            assessmentService.deleteAssessment(id);
            return ResponseEntity.ok(new ApiResponse(id));
        } catch (AssessmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }
    }


}
