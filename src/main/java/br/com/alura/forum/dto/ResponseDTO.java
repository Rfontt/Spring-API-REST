package br.com.alura.forum.dto;

import br.com.alura.forum.model.Response;

import java.time.LocalDateTime;

public class ResponseDTO {
    private Long id;
    private String message;
    private LocalDateTime localDateTime;

    public ResponseDTO(Response response) {
        this.id = response.getId();
        this.message = response.getMessage();
        this.localDateTime = response.getDateCriation();
    }

    public String getMessage() {
        return message;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
