package org.copper.manager.controller;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.service.status.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<StatusResponse>> getAll(){
        return ResponseEntity.ok(statusService.getAll());
    }
}
