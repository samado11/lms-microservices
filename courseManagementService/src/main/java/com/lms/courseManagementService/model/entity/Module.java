package com.lms.courseManagementService.model.entity;

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
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name = "module_order")
    private int moduleOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
    private List<Lesson> lessons;


}
