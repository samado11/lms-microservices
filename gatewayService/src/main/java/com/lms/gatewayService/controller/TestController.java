package com.lms.gatewayService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/sayhello")
    public String getAuditingActions(){
        return "HELLO RAMZYYYYY";
    }
}