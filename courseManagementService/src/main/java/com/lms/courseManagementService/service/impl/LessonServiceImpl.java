package com.lms.courseManagementService.service.impl;

import com.lms.courseManagementService.dto.LessonDTO;
import com.lms.courseManagementService.exception.LessonNotFoundException;
import com.lms.courseManagementService.mapper.LessonMapper;
import com.lms.courseManagementService.model.entity.Lesson;
import com.lms.courseManagementService.repository.LessonRepository;
import com.lms.courseManagementService.service.LessonService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@Data
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    @Transactional
    public LessonDTO save(LessonDTO lessonRequest) {
        Lesson lesson = lessonMapper.toEntity(lessonRequest);
        Lesson savedLesson = lessonRepository.save(lesson);
        return lessonMapper.toResponse(savedLesson);
    }

    @Override
    @Transactional
    public LessonDTO update(Long id, LessonDTO lessonRequest) {
        Lesson existingLesson = this.findLessonById(id);
        lessonMapper.update(lessonRequest, existingLesson);
        return lessonMapper.toResponse(existingLesson);
    }

    @Override
    public LessonDTO getById(Long id) {
        return lessonMapper.toResponse(this.findLessonById(id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Lesson lesson = findLessonById(id);
        lessonRepository.delete(lesson);
    }

    // helper methods
    private Lesson findLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException(id));
    }
}
