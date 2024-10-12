package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


@Component
@Entity
public class lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    String title;
    String description;
    String schedule;
    @jakarta.persistence.Id
    private Long id;

    public lessons(int id,String title, String description, String schedule) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.schedule = schedule;

    }
    public lessons() {

    }
    public String getTitle() {
            return title;
    }
    public void setTitle(String title) {
            this.title = title;
    }
    public String getDescription() {
            return description;
    }
    public void setDescription(String description) {
            this.description = description;
    }
    public String getSchedule() {
            return schedule;
    }
    public void setSchedule(String schedule) {
            this.schedule = schedule;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long get() {
        return id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getId() {
        return Id;
    }

}
