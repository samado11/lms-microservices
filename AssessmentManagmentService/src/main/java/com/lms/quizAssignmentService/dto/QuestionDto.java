package com.lms.quizAssignmentService.dto;

import com.lms.quizAssignmentService.model.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.lms.quizAssignmentService.model.Question}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto implements Serializable {
    private Long id;
    private String questionText;
    private QuestionType questionType;
    private List<Long> assessmentIds;
    private List<Long> optionIds;


}