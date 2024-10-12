package com.lms.courseManagementService.dto;

import com.lms.courseManagementService.model.Course;
import com.lms.courseManagementService.model.Lesson;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ModuleDTO {

    private Long id;
    private String title;
    private String description;
    private int order;
    private Long courseId;
    private String courseTitle;
    private List<LessonDTO> lessons = new ArrayList<>();

    public ModuleDTO(Long id, String title, String description, int order, Long courseId, String courseTitle, List<LessonDTO> lessons) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.order = order;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.lessons = lessons;
    }
}
