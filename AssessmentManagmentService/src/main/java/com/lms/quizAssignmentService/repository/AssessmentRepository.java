package com.lms.quizAssignmentService.repository;

import com.lms.quizAssignmentService.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}