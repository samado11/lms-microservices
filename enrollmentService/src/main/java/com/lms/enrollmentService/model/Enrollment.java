package com.lms.enrollmentService.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;
@Entity
@Table(name = "enrollment")
@Getter
@Setter
@NoArgsConstructor
public class Enrollment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany
    @JoinColumn(name = "id")
    private UUID userId;
    @ManyToMany
    @JoinColumn(name = "id")
    private UUID courseId;
    private Timestamp enrolled_at;
    private Enum status;

}
