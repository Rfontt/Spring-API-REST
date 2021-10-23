package br.com.alura.forum.dto;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.repository.CourseRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CourseForm {
    private Long id;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String category;

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Course convert() {
        return new Course(name, category);
    }
}
