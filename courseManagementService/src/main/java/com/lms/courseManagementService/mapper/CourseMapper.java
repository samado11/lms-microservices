package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.dto.CourseDTO;
import com.lms.courseManagementService.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    CourseDTO toResponse(Course course);

    Course toEntity(CourseDTO courseRequest);

    void update(CourseDTO courseRequest, @MappingTarget Course course);
}
