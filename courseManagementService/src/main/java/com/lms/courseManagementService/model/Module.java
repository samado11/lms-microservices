package com.lms.courseManagementService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Column(name = "[order]")
    private int order;

    @OneToMany(mappedBy = "module")
    private List<Lesson> lessons;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


}
