package com.lms.quizAssignmentService.service;

import com.lms.quizAssignmentService.dto.AssessmentDto;

import java.util.List;

public interface AssessmentService {

    List<AssessmentDto> getAllAssessments();
    AssessmentDto getAssessmentById(Long id);
    AssessmentDto createAssessment(AssessmentDto assessmentDto);
    AssessmentDto updateAssessment(Long id,AssessmentDto assessmentDto);
    void deleteAssessment(Long id);

}
