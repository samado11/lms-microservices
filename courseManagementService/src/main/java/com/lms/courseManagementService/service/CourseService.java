package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.CourseDTO;

import java.util.List;


public interface CourseService {
    CourseDTO save(CourseDTO lessonRequest);

    CourseDTO update(CourseDTO lessonRequest);

    CourseDTO getById(Long id);

    List<CourseDTO> getAll();

    void deleteById(Long id);
}
