package com.lms.quizAssignmentService.service.impl;


import com.lms.quizAssignmentService.dto.AssessmentDto;
import com.lms.quizAssignmentService.exception.AssessmentNotFoundException;
import com.lms.quizAssignmentService.mapper.AssessmentMapper;

import com.lms.quizAssignmentService.mapper.QuestionMapper;
import com.lms.quizAssignmentService.model.Assessment;
import com.lms.quizAssignmentService.model.Question;
import com.lms.quizAssignmentService.repository.AssessmentRepository;

import com.lms.quizAssignmentService.repository.QuestionRepository;
import com.lms.quizAssignmentService.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final AssessmentMapper assessmentMapper;
    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;



    @Override
    public List<AssessmentDto> getAllAssessments() {

        return assessmentRepository.findAll()
                .stream().map(assessmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssessmentDto getAssessmentById(Long id) {

        return assessmentMapper.toDto(assessmentRepository.findById(id)
                .orElseThrow(() -> new AssessmentNotFoundException("Assessment Not Found!")));
    }

    @Transactional
    @Override
    public AssessmentDto createAssessment(AssessmentDto assessmentDto) {



        Assessment assessment = assessmentMapper.toEntity(assessmentDto);

        List<Question> questions = createQuestions(assessmentDto);
        for (Question question : questions) {
            question = questionRepository.save(question);
        }
        assessment.setQuestions(questions);
        Assessment savedAssessment = assessmentRepository.save(assessment);
        return assessmentMapper.toDto(savedAssessment);
    }

    @Transactional
    @Override
    public AssessmentDto updateAssessment(Long id,AssessmentDto assessmentDto) {

        Assessment existingAssessment = assessmentRepository.findById(id)
                .orElseThrow(() -> new AssessmentNotFoundException("Assessment Not Found!"));

        existingAssessment.setTitle(assessmentDto.getTitle());

        existingAssessment.setQuestions(createQuestions(assessmentDto));

        Assessment savedAssessment = assessmentRepository.save(existingAssessment);

        return assessmentMapper.toDto(savedAssessment);
    }

    @Transactional
    @Override
    public void deleteAssessment(Long id) {

        assessmentRepository.findById(id)
                .ifPresentOrElse(assessmentRepository::delete, () -> {
                    throw new AssessmentNotFoundException("Assessment Not Found!");
                });


    }


    private List<Question> createQuestions(AssessmentDto assessmentDto){
        List<Question> questions = assessmentDto.getQuestions().stream()
                .map(questionMapper::toEntity)
                .collect(Collectors.toList());

        return questions;

    }


}
