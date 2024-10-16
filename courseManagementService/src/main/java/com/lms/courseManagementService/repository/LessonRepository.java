package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
