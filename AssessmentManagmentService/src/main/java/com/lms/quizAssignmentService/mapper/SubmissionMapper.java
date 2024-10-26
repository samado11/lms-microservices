package com.lms.quizAssignmentService.mapper;

import com.lms.quizAssignmentService.dto.AssessmentResultDto;
import com.lms.quizAssignmentService.model.AssessmentResult;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionMapper {

    private final ModelMapper modelMapper;

    public AssessmentResultDto toDto(AssessmentResult assessmentResult) {
        return modelMapper.map(assessmentResult, AssessmentResultDto.class);
    }

    public AssessmentResult toEntity(AssessmentResultDto assessmentResultDto) {
        return modelMapper.map(assessmentResultDto, AssessmentResult.class);
    }
}
