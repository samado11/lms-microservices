package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleEntityRepository extends JpaRepository<ModuleEntity, UUID> {

}
