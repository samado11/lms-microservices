package com.lms.assessmentManagmentService.repository;

import com.lms.assessmentManagmentService.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
