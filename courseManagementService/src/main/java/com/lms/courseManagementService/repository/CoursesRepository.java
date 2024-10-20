package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CoursesRepository extends JpaRepository<CourseModel, UUID> {

}
