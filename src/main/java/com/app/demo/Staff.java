package com.app.demo;

// this is model:!!!!

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;



public class Staff {
    @NotBlank(message = "this is a epmty")
    private String name;

    @NotBlank(message = "this is a epmty")
    private String title;

    @NotBlank(message = "this is a epmty")
    private double salary;
    
    private String id;

    public Staff(String name, String title, double salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    
}
public Staff(String name){
    System.err.println("Hello, welcom To Our Page" + name);
}


    public String getid(){
        return this.id;
    }

    public void setid(String id){
        this.id = id;
    }

    public Staff(){
        this.id = UUID.randomUUID().toString();
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}