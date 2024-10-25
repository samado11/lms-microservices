package com.lms.quizAssignmentService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment_results")
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    private int score;

    private boolean passed;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

}
