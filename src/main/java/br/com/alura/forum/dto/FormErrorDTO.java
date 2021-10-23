package br.com.alura.forum.dto;

public class FormErrorDTO {
    private String field;
    private String error;

    public FormErrorDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public String getField() {
        return field;
    }
}
