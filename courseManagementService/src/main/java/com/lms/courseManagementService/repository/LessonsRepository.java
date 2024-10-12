package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
}