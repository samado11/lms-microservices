package com.lms.courseManagementService.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO  {


    private Long id;
    private String title;
    private String description;
    private String category;
    private List<ModuleDTO> modules;

}
