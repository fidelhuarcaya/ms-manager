package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.EquipmentRequest;
import org.copper.manager.dto.response.EquipmentResponse;
import org.copper.manager.service.equipment.EquipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {
    private final EquipmentService equipmentService;
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<EquipmentResponse>> getAll() {
        return ResponseEntity.ok(equipmentService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EquipmentResponse> create(@RequestBody @Valid EquipmentRequest request) {
        return ResponseEntity.ok(equipmentService.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<EquipmentResponse> update(@PathVariable Long id, @RequestBody @Valid EquipmentRequest request) {
        return ResponseEntity.ok(equipmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
