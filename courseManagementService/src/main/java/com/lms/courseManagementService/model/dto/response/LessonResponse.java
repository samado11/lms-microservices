package com.lms.courseManagementService.model.dto.response;

import com.lms.courseManagementService.model.enums.ContentType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record LessonResponse(
        Long id,
        String title,
        ContentType contentType,
        String contentUrl,
        int order
) {
}
