package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.ResourceRequest;
import org.copper.manager.dto.response.ResourceResponse;
import org.copper.manager.service.resource.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll() {
        return ResponseEntity.ok(resourceService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ResourceResponse> create(@RequestBody @Valid ResourceRequest request) {
        return ResponseEntity.ok(resourceService.create(request));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ResourceResponse> update(@PathVariable("id") Long id, @RequestBody @Valid ResourceRequest request) {
        return ResponseEntity.ok(resourceService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        resourceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<ResourceResponse>> getByTopic(@PathVariable("topicId") Long topicId) {
        return ResponseEntity.ok(resourceService.getByTopic(topicId));
    }
}
