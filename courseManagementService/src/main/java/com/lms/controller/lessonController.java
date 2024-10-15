package com.lms.controller;

import com.lms.repo.Leo_Repo;
import com.lms.service.service;
import com.lms.model.lesson;
import org.springframework.web.bind.annotation.*;

public class lessonController {
    com.lms.service.service service = new service();
    Leo_Repo repo;
    @GetMapping("/{id}")
    public lesson getlessons(@PathVariable("id") long id) {
        return service.getlessons(id);
    }

    @PostMapping("/lessons")
    public lesson createlessons(@RequestBody lesson lesson) {
        return 	service.createlessons(lesson);
    }


    @PutMapping("/{lessonid}")
    public lesson updatelessons(@PathVariable("lessonid") long lessonId, @RequestBody lesson lesson) {
        return 	service.updatelessons(lessonId, lesson);
    }


    @DeleteMapping("/{id}")
    public void delete_lessons(@PathVariable("id") long id) {
        service.delete_lessons(id);
    }

}
