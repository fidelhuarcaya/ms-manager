package org.copper.manager.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MiningUnitResponse {
    private Long id;

    private String name;

    private String urlLogo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;
}
