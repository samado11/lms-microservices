package model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class assessments {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        long id;
        @UUID
        int lesson_id;
        String title;
        Timestamp create_at;

        public assessments(int lesson_id, String title, Timestamp create_at) {
            this.lesson_id = lesson_id;
            this.title = title;
            this.create_at = create_at;
        }

        public assessments(){}
}
