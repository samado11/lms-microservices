package com.lms.courseManagementService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleDTO {

    private Long id;
    private String title;
    private String description;
    private int moduleOrder;
    private CourseDTO course;

    private List<LessonDTO> lessons;

}
