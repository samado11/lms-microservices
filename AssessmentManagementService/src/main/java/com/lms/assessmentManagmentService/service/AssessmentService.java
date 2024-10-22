package com.lms.assessmentManagmentService.service;

import com.lms.assessmentManagmentService.dto.AssessmentDTO;

public interface AssessmentService {
    AssessmentDTO save(AssessmentDTO assessmentRequest);

    AssessmentDTO getById(Long id);

    AssessmentDTO update(Long id, AssessmentDTO assessmentRequest);

    void deleteById(Long id);
}
