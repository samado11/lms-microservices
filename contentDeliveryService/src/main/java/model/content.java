package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Service
public class content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @UUID
    int lesson_id;
    String content_Url;
    @Enumerated(EnumType.STRING)
    String content_Type;
    Timestamp uploaded_at;

    public content(int lesson_id, String content_Url, String content_Type) {
        this.lesson_id = lesson_id;
        this.content_Url = content_Url;
        this.content_Type = content_Type;
        this.uploaded_at = new Timestamp(System.currentTimeMillis());
    }

    public content(){

    }

    public enum ContentType {
        VIDEO,
        AUDIO,
        IMAGE
    }

}
