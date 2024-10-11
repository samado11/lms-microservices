package com.lms.controller;

import com.lms.model.CourseModel;
import com.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CourseController {
@Autowired
    private CourseService courseService;
@GetMapping("/hello")
public String hello(){
    System.out.println("hello sir");
    return "hello";
}
@PostMapping("/courses")
    public void createCourse(@RequestBody CourseModel courseModel){
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
