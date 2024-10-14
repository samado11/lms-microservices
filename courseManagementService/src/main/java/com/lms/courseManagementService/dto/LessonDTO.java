package com.lms.courseManagementService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDTO {
    private Long id;
    private String title;
    private String contentUrl;
    private int order;
    private Long moduleId;
}