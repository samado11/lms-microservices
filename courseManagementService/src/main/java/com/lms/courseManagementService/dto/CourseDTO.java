package com.lms.courseManagementService.dto;

import lombok.*;

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

}
