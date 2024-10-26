package com.lms.quizAssignmentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.lms.quizAssignmentService.model.AssessmentResult}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentResultDto implements Serializable {
    private Long resultId;
    private int score;
    private boolean passed;
    private Long assessmentId;
}