package com.lms.courseManagementService.service.impl;

import com.lms.courseManagementService.dto.CourseDTO;
import com.lms.courseManagementService.exception.CourseNotFoundException;
import com.lms.courseManagementService.mapper.CourseMapper;
import com.lms.courseManagementService.model.entity.Course;
import com.lms.courseManagementService.repository.CourseRepository;
import com.lms.courseManagementService.service.CourseService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly=true)
@Data
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    @Transactional
    public CourseDTO save(CourseDTO courseRequest) {
        Course course = courseMapper.toEntity(courseRequest);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDTO(savedCourse);
    }

    @Override
    @Transactional
    public CourseDTO update(CourseDTO courseRequest) {
        Course existingCourse = this.findCourseById(courseRequest.getId());
        courseRepository.save(courseMapper.toEntity(courseRequest));
        return courseRequest;
    }

    @Override
    public CourseDTO getById(Long id) {
        return courseMapper.toDTO(this.findCourseById(id));
    }

    @Override
    public List<CourseDTO> getAll() {
        return courseRepository.findAll().stream().map(courseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Course course = findCourseById(id);
        courseRepository.delete(course);
    }

    // helper methods
    private Course findCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }
}
