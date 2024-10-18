package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.ModuleDto;
import com.lms.courseManagementService.mapper.ModuleMapper;
import com.lms.courseManagementService.model.ModuleEntity;
import com.lms.courseManagementService.repository.ModuleEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Service
public class ModuleServiceImp implements ModuleService {
    final ModuleEntityRepository modulesEntityRepository;
    final ModuleMapper moduleMapper;

    public ModuleServiceImp(ModuleEntityRepository modulesEntityRepository, ModuleMapper moduleMapper) {
        this.modulesEntityRepository = modulesEntityRepository;
        this.moduleMapper = moduleMapper;
    }

    @Override
    public ModuleDto save(ModuleDto moduleDto) {
        ModuleEntity savedModules = moduleMapper.toEntity(moduleDto);
        ModuleEntity moduleEntity = modulesEntityRepository.save(savedModules);
        return moduleMapper.toDto(moduleEntity);
    }

    @Override
    public ModuleDto findById(UUID id) {
        /*
        Optional<Module> result = modulesRepository.findById(id);
        Module module = null;
        if (result.isPresent()){
            module = result.get();
        } else {
                throw new RuntimeException("Did not found module id" +id);
        } */

        ModuleEntity moduleEntity = modulesEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("error"));
        return moduleMapper.toDto(moduleEntity);
    }

    @Override
    public ModuleDto updateById(UUID id, ModuleDto moduleDto) {
        ModuleDto moduleDto1 =findById(id);
        ModuleEntity updatedModule = moduleMapper.toUpdateEntity(moduleDto1);
        ModuleEntity module = modulesEntityRepository.save(updatedModule);
        return moduleMapper.toDto(module);
    }

    @Override
    public void deleteById(UUID id) {
        modulesEntityRepository.deleteById(id);
    }
}
