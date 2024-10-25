package com.lms.assessmentManagmentService.mapper;

import com.lms.assessmentManagmentService.dto.AssessmentDTO;
import com.lms.assessmentManagmentService.model.Assessment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface AssessmentMapper {
    Assessment toEntity(AssessmentDTO assessmentDTO);

    AssessmentDTO toDTO(Assessment assessment);

    @Mapping(target="id", ignore=true)
    void update(AssessmentDTO assessmentDTO, @MappingTarget Assessment assessment);
}
