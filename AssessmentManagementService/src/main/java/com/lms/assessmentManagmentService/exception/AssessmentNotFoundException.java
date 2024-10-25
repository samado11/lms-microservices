package com.lms.assessmentManagmentService.exception;

import jakarta.persistence.EntityNotFoundException;

public class AssessmentNotFoundException extends EntityNotFoundException {
    public AssessmentNotFoundException(Long id) {
        super("Assessment not found with id: " + id);
    }

    public AssessmentNotFoundException(String message) {
        super(message);
    }
}
