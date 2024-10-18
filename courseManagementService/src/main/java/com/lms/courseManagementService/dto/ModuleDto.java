package com.lms.courseManagementService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ModuleDto {
    private UUID id;
    private UUID course_id;
    private String title;
    private String description;
    private int order;
}
