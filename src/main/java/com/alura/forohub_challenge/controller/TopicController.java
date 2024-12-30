package com.alura.forohub_challenge.controller;


import com.alura.forohub_challenge.domain.Topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ServiceTopic serviceTopic;

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid DataCreateTopic dataCreateTopic) {
        var dateTopic = serviceTopic.createTopic(dataCreateTopic);
        return ResponseEntity.ok(dateTopic);
    }

    @GetMapping
    public ResponseEntity<Page<DataTopic>> allTopic(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findByStatus(StatusTopic.ACTIVE,pageable).map(DataTopic::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateTopic(@PathVariable Long id, @RequestBody DataUpdateTopic dataUpdateTopic) {
       var datos =  serviceTopic.updateTopic(id, dataUpdateTopic);
        return ResponseEntity.ok(datos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        serviceTopic.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}