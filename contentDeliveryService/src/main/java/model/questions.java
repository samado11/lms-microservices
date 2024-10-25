package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Entity
@Getter
@Setter
public class questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @UUID
    long id;
    String solution;
    String question_text;
    @Enumerated(EnumType.STRING)
    String questions_type;

    public questions(String solution, String question_text, String questions_type) {
        this.solution = solution;
        this.question_text = question_text;
        this.questions_type = questions_type;
    }

    public questions() {}
}
