package com.lms.enrollmentService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;
@Data
@NoArgsConstructor
public class EnrollmentDto {
    private UUID id;
    private UUID userId;
    private UUID courseId;
    private Timestamp enrolled_at;
    private Enum status;
}
