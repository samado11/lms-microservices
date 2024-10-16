package com.lms.courseManagementService.response;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private Object data;

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
    public ApiResponse(Object data) {
        this.data = data;
    }

}
