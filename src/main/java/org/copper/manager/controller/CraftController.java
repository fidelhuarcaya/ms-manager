package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.response.CraftResponse;
import org.copper.manager.service.craft.CraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crafts")
@RequiredArgsConstructor
public class CraftController {
    private final CraftService craftService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<CraftResponse>> getAll() {
        return ResponseEntity.ok(craftService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CraftResponse> create(@RequestBody @Valid CraftRequest request) {
        return ResponseEntity.ok(craftService.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CraftResponse> update(@PathVariable Long id, @RequestBody @Valid CraftRequest request) {
        return ResponseEntity.ok(craftService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        craftService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
