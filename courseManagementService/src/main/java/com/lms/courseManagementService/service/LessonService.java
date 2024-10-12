package com.lms.courseManagementService.service;

import com.lms.courseManagementService.model.dto.request.LessonRequest;
import com.lms.courseManagementService.model.dto.response.LessonResponse;

import java.util.UUID;

public interface LessonService {
    LessonResponse save(LessonRequest lessonRequest);

    LessonResponse update(UUID id, LessonRequest lessonRequest);

    LessonResponse getById(UUID id);

    void deleteById(UUID id);
}
