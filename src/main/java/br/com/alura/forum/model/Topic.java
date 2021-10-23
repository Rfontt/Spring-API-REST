package br.com.alura.forum.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateCriation = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopic status = StatusTopic.NAO_RESPONDIDO;
    @ManyToOne
    private User author;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "topic")
    private List<Response> responses = new ArrayList<>();

    public Topic() {}

    public Topic(String title, String message, Course course) {
            this.title = title;
            this.message = message;
            this.course = course;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Topic other = (Topic) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public User getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateCriation() {
        return dateCriation;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public StatusTopic getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDateCriation(LocalDateTime dateCriation) {
        this.dateCriation = dateCriation;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    public void setStatus(StatusTopic status) {
        this.status = status;
    }
}
