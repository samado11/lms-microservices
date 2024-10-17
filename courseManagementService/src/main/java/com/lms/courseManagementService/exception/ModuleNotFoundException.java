package com.lms.courseManagementService.exception;

public class ModuleNotFoundException extends RuntimeException {
    public ModuleNotFoundException(Long id) {
        super("module not found with id: " + id);
    }
}
