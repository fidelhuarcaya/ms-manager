package org.copper.manager.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.FavoriteRequest;
import org.copper.manager.dto.response.AreaResponse;
import org.copper.manager.dto.response.FavoriteResponse;
import org.copper.manager.jwt.JwtService;
import org.copper.manager.service.favorite.FavoriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;
    private final JwtService jwtService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'BASIC', 'PREMIUM')")
    public ResponseEntity<List<FavoriteResponse>> getByUserEmail(@RequestHeader("Authorization") String token) {
        String email = jwtService.getUsernameFromToken(token);
        return ResponseEntity.ok(favoriteService.getByUserEmail(email));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'BASIC', 'PREMIUM')")
    public ResponseEntity<FavoriteResponse> save(@RequestBody @Valid FavoriteRequest favoriteRequest) {
        return ResponseEntity.ok(favoriteService.save(favoriteRequest));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'BASIC', 'PREMIUM')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        favoriteService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
