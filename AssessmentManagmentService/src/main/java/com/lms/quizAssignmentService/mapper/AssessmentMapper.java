package com.lms.quizAssignmentService.mapper;

import com.lms.quizAssignmentService.dto.AssessmentDto;
import com.lms.quizAssignmentService.model.Assessment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssessmentMapper {

    private final ModelMapper modelMapper;

    public AssessmentDto toDto(Assessment assessment) {
        return modelMapper.map(assessment, AssessmentDto.class);
    }

    public Assessment toEntity(AssessmentDto assessmentDto) {
        return modelMapper.map(assessmentDto, Assessment.class);
    }


}
