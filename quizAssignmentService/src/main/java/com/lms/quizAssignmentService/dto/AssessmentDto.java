package com.lms.quizAssignmentService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssessmentDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private int createdBy;
    private List<Long> assessmentResults;
    private List<QuestionDto> questions;

}