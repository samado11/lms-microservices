package com.lms.courseManagementService.mapper;


import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.model.entity.Module;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ModuleMapper {

    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);
    ModuleDTO toResponse(Module module);

    Module toEntity(ModuleDTO lessonRequest);

    void update(ModuleDTO lessonRequest, @MappingTarget Module module);
}
