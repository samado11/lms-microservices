package com.lms.quizAssignmentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link com.lms.quizAssignmentService.model.Option}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDto implements Serializable {
    private Long id;
    private String optionText;
    private boolean isCorrect;
    private List<Long> questionIds;

}