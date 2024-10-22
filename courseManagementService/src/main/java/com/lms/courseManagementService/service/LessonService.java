package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.LessonDTO;


public interface LessonService {
    LessonDTO save(LessonDTO lessonRequest);

    LessonDTO update(Long id, LessonDTO lessonRequest);

    LessonDTO getById(Long id);

    void deleteById(Long id);
}
