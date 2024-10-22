package com.lms.assessmentManagmentService.dto;

import com.lms.courseManagementService.model.entity.Lesson;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="lesson_id")
    private Lesson lesson;

    private String title;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

//    todo: to be added IFF needed or create an AssessmentDetailedDTO
//
//    private List<SubmissionsDTO> submissions;
}
