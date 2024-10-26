package com.lms.quizAssignmentService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessments")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Long assessmentId;

    private String title;
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private int createdBy;

    @OneToMany(mappedBy = "assessment")
    private List<AssessmentResult> assessmentResults;

    @ManyToMany
    @JoinTable(
            name = "assessment_questions",
            joinColumns = @JoinColumn(name = "assessment_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
}
