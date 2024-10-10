package com.lms.repository;

import com.lms.model.CourseModel;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {
    @Override
    Optional<CourseModel> findById(UUID uuid);
    Optional<CourseModel> deleteCourseById(UUID uuid);
}
