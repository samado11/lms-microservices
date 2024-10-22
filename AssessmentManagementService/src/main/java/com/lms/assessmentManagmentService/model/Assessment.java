package com.lms.assessmentManagmentService.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="assessments")
public class Assessment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;
// todo: ERROR-> Failed to initialize JPA EntityManagerFactory: Association 'com.lms.assessmentManagmentService.model.Assessment.lesson' targets the type 'com.lms.courseManagementService.model.entity.Lesson' which does not belong to the same persistence unit
//    @ManyToOne
//    @JoinColumn(name="lesson_id")
//    private Lesson lesson;

    private String title;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

//    todo: to be added after making the submission entity
//    @OneToMany(mappedBy = "assessment")
//    private List<Submissions> submissions;

}
