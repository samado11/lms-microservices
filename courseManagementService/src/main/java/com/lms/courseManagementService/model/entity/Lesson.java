package com.lms.courseManagementService.model.entity;

import com.lms.courseManagementService.model.enums.ContentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Lesson extends BaseEntity {
    // todo: add this relationship after implementing Module entity
//    @ManyToOne
//    @JoinColumn(name="module_id", nullable=false)
//    private Module module;

    @Column(nullable=false)
    private String title;

    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    private String contentUrl;

    private int order;

}
