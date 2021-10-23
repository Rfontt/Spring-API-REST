package br.com.alura.forum.dto;

import br.com.alura.forum.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateCriation = LocalDateTime.now();

    public TopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCriation = topic.getDateCriation();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateCriation() {
        return dateCriation;
    }

    public String getMessage() {
        return message;
    }

    public List<TopicDTO> convert(List<Topic> topics) {
        return topics.stream().map(TopicDTO::new).collect(Collectors.toList());
    }
}
