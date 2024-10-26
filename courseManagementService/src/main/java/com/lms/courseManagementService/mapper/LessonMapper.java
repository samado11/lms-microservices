package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.dto.LessonDTO;
import com.lms.courseManagementService.model.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LessonMapper {

    @Autowired
    private ModuleMapper moduleMapper;
    public LessonDTO toDTO(Lesson lesson) {
        if (lesson == null) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setId(lesson.getId());
        lessonDTO.setTitle(lesson.getTitle());
        lessonDTO.setContentType(lesson.getContentType());
        lessonDTO.setContentUrl(lesson.getContentUrl());
        lessonDTO.setLessonOrder(lesson.getLessonOrder());


        return lessonDTO;
    }

    public Lesson toEntity(LessonDTO lessonDTO) {
        if (lessonDTO == null) {
            return null;
        }

        Lesson lesson = new Lesson();
        lesson.setId(lessonDTO.getId());
        lesson.setTitle(lessonDTO.getTitle());
        lesson.setContentType(lessonDTO.getContentType());
        lesson.setContentUrl(lessonDTO.getContentUrl());
        lesson.setLessonOrder(lessonDTO.getLessonOrder());
        lesson.setModule(moduleMapper.toEntity(lessonDTO.getModule()));

        return lesson;
    }

}

