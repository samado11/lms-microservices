package com.lms.assessmentManagmentService.service;

import com.lms.assessmentManagmentService.model.AssessmentModel;
import com.lms.assessmentManagmentService.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AssessmentService {
@Autowired
private AssessmentRepository assessmentRepository;
    public void createAssessment(AssessmentModel assessmentModel){
    assessmentRepository.save(assessmentModel);
}
public Void editAssessment(UUID id, AssessmentModel updatedAssessmentModel){
        Optional<AssessmentModel> existModel = assessmentRepository.findById(id);
        existModel.setId(updatedAssessmentModel.getId());
        existModel.setDescription(updatedAssessmentModel.getDescription());
        existModel.setTitle(updatedAssessmentModel.getTitle());
        existModel.setSchedule(updatedAssessmentModel.getSchedule());
        assessmentRepository.save(existModel);
}
}
