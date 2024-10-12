package com.example.demo;

import jakarta.websocket.ClientEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    lessonsRepo Repo;



    @GetMapping("/lessons/{lessonid}")
    public lessons getlesson(@PathVariable("id") int id) {
        return Repo.findById(id).get();
    }

    @PostMapping("/lessons")
    public lessons createlesson(@RequestBody lessons lesson) {
        return Repo.save(lesson);
    }

    @PutMapping("/lessons/{lessonid}")
    public lessons updatelesson(@RequestBody lessons lesson) {
        return Repo.save(lesson);
    }

    @DeleteMapping("/lessons/{lessonid}")
    public void deletelesson(@PathVariable("id") int id) {
         Repo.findById(id);
    }
    @Test
    public void testsavelesson() {
        lessons lesson = new lessons();
        lesson.setId(1);
        lesson.setDescription("reading");
        lesson.setTitle("arabic");
        Repo.save(lesson);

        lessons lesson1 = Repo.findById(1).get();
        assertNotNull(lesson1);
    }

}
