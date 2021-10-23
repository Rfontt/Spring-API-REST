package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.TopicRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateTopicForm {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull @NotEmpty
    private String message;

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic update(Long id, TopicRepository topicRepository) {
        Topic topic = topicRepository.getOne(id);
        topic.setTitle(this.title);
        topic.setMessage(this.message);

        return topic;
    }
}
