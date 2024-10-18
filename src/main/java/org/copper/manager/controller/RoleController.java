package org.copper.manager.controller;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.response.RoleResponse;
import org.copper.manager.service.role.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<RoleResponse>> getAll(){
        return ResponseEntity.ok(roleService.getAll());
    }
}
