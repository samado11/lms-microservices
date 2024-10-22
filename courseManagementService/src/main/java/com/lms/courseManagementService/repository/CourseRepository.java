package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}