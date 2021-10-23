package br.com.alura.forum.controller;

import br.com.alura.forum.dto.CourseDTO;
import br.com.alura.forum.dto.CourseForm;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<CourseDTO> list() {
        Course course = new Course();
        CourseDTO courseDTO = new CourseDTO(course);
        List<Course> courseList= courseRepository.findAll();

        return courseDTO.convert(courseList);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody @Valid CourseForm form, UriComponentsBuilder uriComponentsBuilder) {
        Course course = form.convert();
        courseRepository.save(course);

        URI uri = uriComponentsBuilder.path("/course/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(uri).body(new CourseDTO(course));
    }
}
