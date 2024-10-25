package com.lms.quizAssignmentService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "student_response")
public class StudentResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id", nullable = false)
    private Long responseId;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}