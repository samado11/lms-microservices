package com.lms.courseManagementService.mapper;


import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.model.entity.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class ModuleMapper {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private LessonMapper lessonMapper;


    public ModuleDTO toDTO(Module module) {
        if (module == null) {
            return null;
        }
        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setId(module.getId());
        moduleDTO.setTitle(module.getTitle());
        moduleDTO.setDescription(module.getDescription());
        moduleDTO.setModuleOrder(module.getModuleOrder());

        moduleDTO.setLessons(module.getLessons().stream().map(lesson -> lessonMapper.toDTO(lesson)).collect(Collectors.toList()));
        return moduleDTO;
    }

    public Module toEntity(ModuleDTO moduleDTO) {
        if (moduleDTO == null) {
            return null;
        }

        Module module = new Module();
        module.setId(moduleDTO.getId());
        module.setTitle(moduleDTO.getTitle());
        module.setDescription(moduleDTO.getDescription());
        module.setModuleOrder(moduleDTO.getModuleOrder());
        module.setCourse(courseMapper.toEntity(moduleDTO.getCourse()));
        return module;
    }

}
