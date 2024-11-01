package com.lms.enrollmentService.service;

import com.lms.enrollmentService.dto.EnrollmentDto;

import java.util.UUID;

public interface EnrollmentService {
    EnrollmentDto findById(UUID uuid);
    EnrollmentDto save(EnrollmentDto enrollmentDto);
    EnrollmentDto updateById(UUID uuid, EnrollmentDto enrollmentDto);
    void deleteById(UUID uuid);
}
