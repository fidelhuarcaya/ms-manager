package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.VideoRequest;
import org.copper.manager.dto.response.VideoResponse;
import org.copper.manager.service.video.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @GetMapping
    public ResponseEntity<List<VideoResponse>> getAll() {
        return ResponseEntity.ok(videoService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<VideoResponse> create(@RequestBody @Valid VideoRequest request) {
        return ResponseEntity.ok(videoService.create(request));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<VideoResponse> update(@PathVariable("id") Long id, @RequestBody @Valid VideoRequest request) {
        return ResponseEntity.ok(videoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        videoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<VideoResponse>> getByTopic(@PathVariable("topicId") Long topicId) {
        return ResponseEntity.ok(videoService.getByTopic(topicId));
    }
}
