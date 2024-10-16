package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepositry extends JpaRepository<Module, Long> {

}
