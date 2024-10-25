package com.lms.assessmentManagmentService.service.impl;

import com.lms.assessmentManagmentService.dto.AssessmentDTO;
import com.lms.assessmentManagmentService.exception.AssessmentNotFoundException;
import com.lms.assessmentManagmentService.mapper.AssessmentMapper;
import com.lms.assessmentManagmentService.model.Assessment;
import com.lms.assessmentManagmentService.repository.AssessmentRepository;
import com.lms.assessmentManagmentService.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;
    private final AssessmentMapper assessmentMapper;

    // todo: handle the assessment.lesson and check if a lesson exists first.
    @Override
    @Transactional
    public AssessmentDTO save(AssessmentDTO assessmentRequest) {
        Assessment assessment = assessmentMapper.toEntity(assessmentRequest);
        Assessment savedAssessment = assessmentRepository.save(assessment);
        return assessmentMapper.toDTO(savedAssessment);
    }

    @Override
    public AssessmentDTO getById(Long id) {
        return assessmentMapper.toDTO(this.findAssessmentById(id));
    }

    @Override
    @Transactional
    public AssessmentDTO update(Long id, AssessmentDTO assessmentRequest) {
        Assessment existingAssessment = this.findAssessmentById(id);
        assessmentMapper.update(assessmentRequest, existingAssessment);
        return assessmentMapper.toDTO(existingAssessment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Assessment assessment = this.findAssessmentById(id);
        assessmentRepository.delete(assessment);
    }

    // helpers
    private Assessment findAssessmentById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(() -> new AssessmentNotFoundException(id));
    }
}
