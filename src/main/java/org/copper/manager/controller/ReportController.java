package org.copper.manager.controller;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.response.ReportResponse;
import org.copper.manager.service.report.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReportResponse> getAll() {
        return ResponseEntity.ok(reportService.generateReport());
    }
}
