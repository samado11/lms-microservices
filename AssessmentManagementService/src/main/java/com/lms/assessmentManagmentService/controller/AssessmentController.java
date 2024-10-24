package com.lms.assessmentManagmentService.controller;

import com.lms.assessmentManagmentService.model.AssessmentModel;
import com.lms.assessmentManagmentService.repository.AssessmentRepository;
import com.lms.assessmentManagmentService.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AssessmentController {
    @Autowired
    AssessmentService assessmentService;
    @PostMapping("/Assessments")
    public void createAssessment(@RequestBody AssessmentModel assessmentModel){
        assessmentService.createAssessment(assessmentModel);
    }
    @PutMapping("/Assessments/{AssessmentId}")
    public void updateAssessment(@PathVariable UUID AssessmentId, @RequestBody AssessmentModel assessmentModel){
        assessmentService.editAssessment(assessmentModel);
    }
}
