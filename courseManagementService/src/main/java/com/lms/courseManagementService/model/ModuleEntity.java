package com.lms.courseManagementService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "modules")
@Setter
@Getter
@NoArgsConstructor
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private UUID course_id;
    private String title;
    private String description;
    private int order;
    @OneToMany(mappedBy = "lessons", cascade = CascadeType.ALL)
    private List<Lessons> lessonsList;
}
