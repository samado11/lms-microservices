package com.lms.courseManagementService.dto;

import com.lms.courseManagementService.model.Course;
import com.lms.courseManagementService.model.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModuleDTO {

    private Long id;
    private String title;
    private String description;
    private int order;
    private Long courseId;
    private String courseTitle;
    private List<LessonDTO> lessons = new ArrayList<>();

}
