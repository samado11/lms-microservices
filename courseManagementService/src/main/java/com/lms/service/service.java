package com.lms.service;

import com.lms.Repositry.Leo_Repo;
import com.lms.courseManagementService.ResourceNotFoundException;
import com.lms.courseManagementService.lesson;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class service {

    Leo_Repo repo;
    public lesson getlessons(@PathVariable("id") long id) {
        return repo.findById(id).orElse(null);
    }

    public lesson createlessons(@RequestBody lesson lesson) {
        return repo.save(lesson);
    }

    public lesson updatelessons(@PathVariable("lessonid") long lessonId, @RequestBody lesson lesson) {
        if (!repo.existsById(lessonId)) {
            throw new ResourceNotFoundException("Lesson not found with id: " + lessonId);
        }
        lesson.setId(lessonId);
        return repo.save(lesson);
    }


    public void delete_lessons(@PathVariable("id") long id) {
        repo.deleteById(id);
    }


}
