package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.dto.CourseDTO;
import com.lms.courseManagementService.model.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class CourseMapper {

    @Autowired
    private ModuleMapper moduleMapper;



    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setCategory(course.getCategory());
        courseDTO.setModules(course.getModules().stream().map(module -> moduleMapper.toDTO(module)).collect(Collectors.toList()));
        return courseDTO;
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setCategory(courseDTO.getCategory());

        return course;
    }
}
