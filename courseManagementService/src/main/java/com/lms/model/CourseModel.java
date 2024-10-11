package com.lms.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "coursess")
public class CourseModel {
@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
private String title;
private String description;
private String category;
private UUID instructorId;
private Enum status;
private Timestamp created_at;
private Timestamp updated_at;
}
