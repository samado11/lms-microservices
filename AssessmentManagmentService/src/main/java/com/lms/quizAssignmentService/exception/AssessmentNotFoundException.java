package com.lms.quizAssignmentService.exception;

public class AssessmentNotFoundException extends RuntimeException {
    public AssessmentNotFoundException(String message) {
        super(message);
    }
}
