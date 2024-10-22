package com.lms.quizAssignmentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.lms.quizAssignmentService.model.Submission}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDto implements Serializable {
    private Long id;
    private LocalDateTime submittedAt;
    private int score;
    private Long assessmentId;
}