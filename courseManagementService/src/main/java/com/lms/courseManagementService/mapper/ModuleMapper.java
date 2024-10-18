package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.dto.ModuleDto;
import com.lms.courseManagementService.model.ModuleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleDto toDto(ModuleEntity module);
    ModuleEntity toUpdateEntity(ModuleDto moduleDto);
    ModuleEntity toEntity(ModuleDto moduleDto);
}
