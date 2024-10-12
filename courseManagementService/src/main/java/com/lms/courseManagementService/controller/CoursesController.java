package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.domain.Course;
import com.lms.courseManagementService.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoursesController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }
}
