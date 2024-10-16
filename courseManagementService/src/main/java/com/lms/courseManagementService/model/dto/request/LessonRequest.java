package com.lms.courseManagementService.model.dto.request;

import com.lms.courseManagementService.model.enums.ContentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record LessonRequest(
        @NotBlank
        String title,
        @NotNull
        ContentType contentType,
        @NotNull
        String contentUrl,
        @NotNull
        int order
) {
}
