package com.lms.quizAssignmentService.mapper;

import com.lms.quizAssignmentService.dto.QuestionDto;
import com.lms.quizAssignmentService.model.Question;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final ModelMapper modelMapper;

    public QuestionDto toDto(Question question) {
        return modelMapper.map(question, QuestionDto.class);
    }

    public Question toEntity(QuestionDto questionDto) {
        return modelMapper.map(questionDto, Question.class);
    }
}
