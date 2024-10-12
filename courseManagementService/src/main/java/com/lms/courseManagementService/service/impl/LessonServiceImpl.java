package com.lms.courseManagementService.service.impl;

import com.lms.courseManagementService.exception.LessonNotFoundException;
import com.lms.courseManagementService.mapper.LessonMapper;
import com.lms.courseManagementService.model.dto.request.LessonRequest;
import com.lms.courseManagementService.model.dto.response.LessonResponse;
import com.lms.courseManagementService.model.entity.Lesson;
import com.lms.courseManagementService.repository.LessonRepository;
import com.lms.courseManagementService.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    @Transactional
    public LessonResponse save(LessonRequest lessonRequest) {
        Lesson lesson = lessonMapper.toEntity(lessonRequest);
        Lesson savedLesson = lessonRepository.save(lesson);
        return lessonMapper.toResponse(savedLesson);
    }

    @Override
    @Transactional
    public LessonResponse update(UUID id, LessonRequest lessonRequest) {
        Lesson existingLesson = this.findLessonById(id);
        lessonMapper.update(lessonRequest, existingLesson);
        return lessonMapper.toResponse(existingLesson);
    }

    @Override
    public LessonResponse getById(UUID id) {
        return lessonMapper.toResponse(this.findLessonById(id));
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        Lesson lesson = findLessonById(id);
        lessonRepository.delete(lesson);
    }

    // helper methods
    private Lesson findLessonById(UUID id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));
    }
}
