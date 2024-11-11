package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.TopicRequest;
import org.copper.manager.dto.response.TopicResponse;
import org.copper.manager.service.topic.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getAll() {
        return ResponseEntity.ok(topicService.getAll());
    }

    @PostMapping
    public ResponseEntity<TopicResponse> create(@RequestBody @Valid TopicRequest request) {
        return ResponseEntity.ok(topicService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicResponse> update(@PathVariable("id") Long id, @RequestBody @Valid TopicRequest request) {
        return ResponseEntity.ok(topicService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        topicService.delete(id);
        return ResponseEntity.ok().build();
    }



}