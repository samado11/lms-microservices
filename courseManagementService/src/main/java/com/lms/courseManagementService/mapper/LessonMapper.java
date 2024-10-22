package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.dto.LessonDTO;
import com.lms.courseManagementService.model.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);
    LessonDTO toResponse(Lesson lesson);

    Lesson toEntity(LessonDTO lessonRequest);

    void update(LessonDTO lessonRequest, @MappingTarget Lesson lesson);
}
