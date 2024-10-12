package com.lms.courseManagementService.exception;

import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class LessonNotFoundException extends EntityNotFoundException {
    public LessonNotFoundException(Long id) {
        super("Lesson not found with id: " + id);
    }

    public LessonNotFoundException(String message) {
        super(message);
    }
}
