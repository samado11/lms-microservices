package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.model.dto.request.LessonRequest;
import com.lms.courseManagementService.model.dto.response.LessonResponse;
import com.lms.courseManagementService.model.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface LessonMapper {
    LessonResponse toResponse(Lesson lesson);

    Lesson toEntity(LessonRequest lessonRequest);

    void update(LessonRequest lessonRequest, @MappingTarget Lesson lesson);
}
