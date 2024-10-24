package com.lms.assessmentManagmentService.repository;

import com.lms.assessmentManagmentService.model.AssessmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AssessmentRepository extends JpaRepository<AssessmentModel, UUID> {
    @Override
    Optional<AssessmentModel> findById(UUID uuid);
}
