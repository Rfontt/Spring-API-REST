package br.com.alura.forum.dto;

import br.com.alura.forum.model.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDTO {
    private Long id;
    private String name;
    private String category;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.category = course.getCategory();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public List<CourseDTO> convert(List<Course> courseList) {
        return courseList.stream().map(CourseDTO::new).collect(Collectors.toList());
    }
}
