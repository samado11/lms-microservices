package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.LessonDTO;

import java.util.List;


public interface LessonService {
    LessonDTO save(LessonDTO lessonRequest);

    LessonDTO update(LessonDTO lessonRequest);

    LessonDTO getById(Long id);

    List<LessonDTO> getAll();

    void deleteById(Long id);
}
