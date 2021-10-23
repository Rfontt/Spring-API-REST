package br.com.alura.forum.dto;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.StatusTopic;
import br.com.alura.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailsTopicDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime dateCriation;
    private StatusTopic statusTopic;
    private List<ResponseDTO> responseDTO;

    public DetailsTopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateCriation = topic.getDateCriation();
        this.statusTopic = topic.getStatus();
        this.responseDTO = new ArrayList<>();
        this.responseDTO.addAll(topic.getResponses().stream().map(ResponseDTO::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateCriation() {
        return dateCriation;
    }

    public List<ResponseDTO> getResponseDTO() {
        return responseDTO;
    }

    public StatusTopic getStatusTopic() {
        return statusTopic;
    }
}
