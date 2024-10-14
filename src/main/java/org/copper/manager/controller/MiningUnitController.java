package org.copper.manager.controller;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;
import org.copper.manager.entity.MiningUnit;
import org.copper.manager.service.mining.unit.MiningUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mining-units")
public class MiningUnitController {
    private final MiningUnitService miningUnitService;

    @GetMapping
    public ResponseEntity<List<MiningUnitResponse>> getAll() {
        return ResponseEntity.ok(miningUnitService.getAll());
    }

    @PostMapping
    public ResponseEntity<MiningUnitResponse> create(MiningUnitRequest request) {
        return ResponseEntity.ok(miningUnitService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MiningUnitResponse> update(@PathVariable Long id, MiningUnitRequest request) {
        return ResponseEntity.ok(miningUnitService.update(id, request));
    }
}
