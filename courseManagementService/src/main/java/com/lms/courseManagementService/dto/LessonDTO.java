package com.lms.courseManagementService.dto;

import com.lms.courseManagementService.model.enums.ContentType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDTO {
    private Long id;
    private String title;
    private String contentUrl;
    private int lessonOrder;
    private ContentType contentType;
    private ModuleDTO moduleDTO;
}