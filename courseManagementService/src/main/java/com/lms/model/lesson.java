package com.lms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@Entity
        public class lesson {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @jakarta.persistence.Id
        @Id
        Long id;
        String title;
        String description;
        String schedule;



        public lesson(String title, String description, String schedule) {
            this.title = title;
            this.description = description;
            this.schedule = schedule;

        }
        public lesson(){
        }

        public void setId(long id) {
            this.id = id;
        }
        }

