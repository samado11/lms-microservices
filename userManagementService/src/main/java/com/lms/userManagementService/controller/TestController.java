package com.lms.userManagementService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/sayhelloo")
    public String getAuditingActions(){
        return "HELLO FROM USER MANAGMENT";
    }
}
