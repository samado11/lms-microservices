package com.lms.assessmentManagmentService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table
public class AssessmentModel {
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
private String title;
private String description;
private Timestamp schedule;
}
