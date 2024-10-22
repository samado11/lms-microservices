package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.CourseDTO;


public interface CourseService {
    CourseDTO save(CourseDTO lessonRequest);

    CourseDTO update(Long id, CourseDTO lessonRequest);

    CourseDTO getById(Long id);

    void deleteById(Long id);
}
