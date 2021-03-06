package br.com.alura.forum.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private Topic topic;
    private LocalDateTime dateCriation = LocalDateTime.now();
    @ManyToOne
    private Users author;
    private Boolean solution = false;

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
        Response other = (Response) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public Boolean getSolution() {
        return solution;
    }

    public LocalDateTime getDateCriation() {
        return dateCriation;
    }

    public String getMessage() {
        return message;
    }

    public Topic getTopic() {
        return topic;
    }

    public Users getAuthor() {
        return author;
    }
}
