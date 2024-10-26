package com.lms.quizAssignmentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.lms.quizAssignmentService.model.StudentResponse}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto implements Serializable {
    private Long responseId;
    private String answerText;
    private Long questionQuestionId;
}