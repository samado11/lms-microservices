package com.lms.courseManagementService.service.impl;

import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.exception.ModuleNotFoundException;
import com.lms.courseManagementService.mapper.ModuleMapper;
import com.lms.courseManagementService.model.entity.Module;
import com.lms.courseManagementService.repository.ModulesRepository;
import com.lms.courseManagementService.service.ModuleService;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModulesRepository moduleRepository;

    private final ModuleMapper moduleMapper;


    @Override
    public List<ModuleDTO> getAll() {

        return moduleRepository.findAll()
                .stream().map(moduleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ModuleDTO getById(Long id) {

        Module module = moduleRepository.findById(id)
                .orElseThrow(() -> new ModuleNotFoundException(id));
        return moduleMapper.toResponse(module);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ModuleDTO save(ModuleDTO request) {

        Module module = moduleMapper.toEntity(request);
        Module savedModule = moduleRepository.save(module);
        return moduleMapper.toResponse(savedModule);

    }



    @Transactional
    public ModuleDTO update(Long id, ModuleDTO request) {
        Module existingModule = moduleRepository.findById(id)
                .orElseThrow(() -> new ModuleNotFoundException(id));
        moduleMapper.update(request, existingModule);
        return moduleMapper.toResponse(existingModule);
    }

    public List<ModuleDTO> getModulesByCourseTitle(String courseTitle) {

        return moduleRepository.findByTitle(courseTitle)
                .stream()
                .map(moduleMapper::toResponse)
                .collect(Collectors.toList());
    }

}
