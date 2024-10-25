package com.lms.quizAssignmentService.repository;

import com.lms.quizAssignmentService.model.AssessmentResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<AssessmentResult, Long> {
}