package com.lms.quizAssignmentService.mapper;


import com.lms.quizAssignmentService.dto.OptionDto;
import com.lms.quizAssignmentService.model.Option;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptionMapper {

    private final ModelMapper modelMapper;

    public OptionDto toDto(Option option) {
        return modelMapper.map(option, OptionDto.class);
    }

    public Option toEntity(OptionDto optionDto) {
        return modelMapper.map(optionDto, Option.class);
    }
}
