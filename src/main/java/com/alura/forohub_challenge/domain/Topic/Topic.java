package com.alura.forohub_challenge.domain.Topic;
import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.user.FinalUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "topic")
@Table(name = "topics")
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @DateTimeFormat
    private LocalDateTime date;
    private StatusTopic status;
    private FinalUser username;
    private Course course;
}
