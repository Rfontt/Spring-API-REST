package br.com.alura.forum.dto;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicForm {
    @NotNull @NotEmpty
    private String title;
    @NotNull @NotEmpty
    private String message;
    @NotNull @NotEmpty
    private String nameCourse;

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic convert(CourseRepository courseRepository) {
        Course course = courseRepository.findByName(nameCourse);
        return new Topic(title, message, course);
    }
}
