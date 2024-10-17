package com.lms.courseManagementService.model.entity;

import com.lms.courseManagementService.model.enums.ContentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(name = "contenttype",nullable = false)
    private ContentType contentType;

    @Column(name = "contenturl")
    private String contentUrl;

    @Column(name = "Lessonorder")
    private Integer lessonOrder;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

}
