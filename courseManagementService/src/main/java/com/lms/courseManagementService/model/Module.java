package com.lms.courseManagementService.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String title;
    private String Description;
    private  Integer order;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    public Module(Long id, String title, String description, Integer order, List<Course> courses) {
        this.id = id;
        this.title = title;
        Description = description;
        this.order = order;
        this.courses = courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDescription() {
        return Description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getOrder() {
        return order;
    }

    public List<Course> getCourses() {
        return courses;
    }



}
