package com.lms.quizAssignmentService.repository;

import com.lms.quizAssignmentService.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}