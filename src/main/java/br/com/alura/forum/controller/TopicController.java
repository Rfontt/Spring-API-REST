package br.com.alura.forum.controller;

import br.com.alura.forum.dto.DetailsTopicDTO;
import br.com.alura.forum.dto.TopicDTO;
import br.com.alura.forum.dto.TopicForm;
import br.com.alura.forum.dto.UpdateTopicForm;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDTO> list(String nameCourse) {
        Topic topic = new Topic();
        TopicDTO topicDTO = new TopicDTO(topic);
        List<Topic> topicListAll = topicRepository.findAll();
        List<Topic> topicsListOne = topicRepository.findByCourseName(nameCourse);

        if (nameCourse != null) {
            return topicDTO.convert(topicsListOne);
        } else {
            return topicDTO.convert(topicListAll);
        }
    }

    @PostMapping
    public ResponseEntity<TopicDTO> save(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = form.convert(courseRepository);
        topicRepository.save(topic);

        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDTO(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsTopicDTO> details(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (topic.isPresent()) {
            return ResponseEntity.ok(new DetailsTopicDTO(topic.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateTopicForm form) {
        Optional<Topic> optional = topicRepository.findById(id);

        if (optional.isPresent()) {
            Topic topic = form.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDTO(topic));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);

        if (topic.isPresent()) {
            topicRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

