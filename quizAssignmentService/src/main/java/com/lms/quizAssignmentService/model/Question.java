package com.lms.quizAssignmentService.model;

import com.lms.quizAssignmentService.model.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "question_type")
    private QuestionType questionType;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "questions")
    private List<Assessment> assessments;

    @ManyToMany
    @JoinTable(
            name = "question_option",
            joinColumns = @JoinColumn(name ="question_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id")
    )
    private List<Option> options;

    @OneToMany(mappedBy = "question")
    private List<StudentResponse> studentResponses;


}
