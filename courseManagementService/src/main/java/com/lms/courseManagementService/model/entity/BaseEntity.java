package com.lms.courseManagementService.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@ToString
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

}