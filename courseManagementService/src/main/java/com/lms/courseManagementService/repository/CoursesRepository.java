package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {
}