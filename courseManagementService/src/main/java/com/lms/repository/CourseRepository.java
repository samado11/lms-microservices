package com.lms.repository;

import com.lms.model.CourseModel;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {
}
