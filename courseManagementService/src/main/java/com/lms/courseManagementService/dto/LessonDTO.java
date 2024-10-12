package com.lms.courseManagementService.dto;

import lombok.Data;

@Data
public class LessonDTO {
    private Long id;
    private String title;
    private String content_url;
    private int order;
    private Long moduleId;


    public LessonDTO(Long id, String title, String contentUrl, int order, Long id1) {
        this.id = id;
        this.title = title;
        this.content_url = contentUrl;
        this.order = order;
        this.moduleId = id1;
    }


}