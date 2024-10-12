package com.lms.courseManagementService.service;

import com.lms.courseManagementService.model.dto.request.LessonRequest;
import com.lms.courseManagementService.model.dto.response.LessonResponse;

import java.util.UUID;

public interface LessonService {
    LessonResponse save(LessonRequest lessonRequest);

    LessonResponse update(Long id, LessonRequest lessonRequest);

    LessonResponse getById(Long id);

    void deleteById(Long id);
}
