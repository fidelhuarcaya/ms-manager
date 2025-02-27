package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.AreaRequest;
import org.copper.manager.dto.response.AreaResponse;
import org.copper.manager.service.area.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/areas")
public class AreaController {
    private final AreaService areaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'BASIC', 'PREMIUM', 'ROLE_ANONYMOUS')")
    public ResponseEntity<List<AreaResponse>> getAll() {
        return ResponseEntity.ok(areaService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AreaResponse> create(@RequestBody @Valid AreaRequest request) {
        return ResponseEntity.ok(areaService.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AreaResponse> update(@PathVariable("id") Integer id, @RequestBody @Valid AreaRequest request) {
        return ResponseEntity.ok(areaService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        areaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{miningUnitId}")
    public ResponseEntity<List<AreaResponse>> getByMiningUnitId(@PathVariable("miningUnitId") Long miningUnitId) {
        return ResponseEntity.ok(areaService.getByMiningUnitId(miningUnitId));
    }
}
