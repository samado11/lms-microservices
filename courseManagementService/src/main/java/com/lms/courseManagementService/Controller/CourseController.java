package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.model.CourseModel;
import com.lms.courseManagementService.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<CourseModel> getAllCourses() {
        System.out.println("get courses");
        return courseService.getAllCourses();
    }
    @PostMapping("/courses")
    public void createCourse(@RequestBody CourseModel courseModel){
        System.out.println("post course");
        courseService.createCourse(courseModel);
    }
    @PutMapping("/courses/{courseId}")
    public void editCourse(@RequestBody CourseModel courseModel,@PathVariable UUID courseId){
        courseService.editCourse(courseId,courseModel);
    }
    @GetMapping("/courses/{courseId}")
    public void viewCourse (@PathVariable UUID courseId){
        courseService.viewCourse(courseId);
    }
    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable UUID courseId){
        courseService.deleteCourse(courseId);
    }
}
