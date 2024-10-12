package com.lms.courseManagementService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content_url;

    @Column(name = "[order]")
    private int order;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    public Lesson(String title) {
        this.title = title;
    }
}
