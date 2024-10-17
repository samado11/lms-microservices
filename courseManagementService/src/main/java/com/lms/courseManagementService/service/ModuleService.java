package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.ModuleDTO;

import java.util.List;



public interface ModuleService {

    ModuleDTO save(ModuleDTO lessonRequest);

    ModuleDTO update(Long id, ModuleDTO lessonRequest);

    ModuleDTO getById(Long id);

    void deleteById(Long id);

    List<ModuleDTO> getAll();
}
