package com.alura.forohub_challenge.domain.Topic;
import com.alura.forohub_challenge.domain.Course.Course;
import com.alura.forohub_challenge.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "topic")
@Table(name = "topics")

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private StatusTopic status;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @NotNull
    private Course course;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    private boolean visible = true;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public @NotBlank String getMessage() {
        return message;
    }

    public void setMessage(@NotBlank String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public StatusTopic getStatus() {
        return status;
    }

    public void setStatus(StatusTopic status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Topic(Long id, String title, String message, LocalDateTime date, StatusTopic status, Course course, User user, boolean visible) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.date = date;
        this.status = status;
        this.course = course;
        this.user = user;
        this.visible = visible;
    }

    public Topic() {
    }


    public void updateTopic(UpdateTopicData dataUpdate) {
        if (dataUpdate.title()!= null) {
            this.title = dataUpdate.title();
        }
        if (dataUpdate.message() != null) {
            this.message = dataUpdate.message();
        }
        if (dataUpdate.status() != null) {
            this.status = dataUpdate.status();
        }
    }
}
