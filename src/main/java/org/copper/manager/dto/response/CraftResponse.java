package org.copper.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CraftResponse(
        Long id,
        String name,
        EquipmentResponse equipment,
        StatusResponse status,

        @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
        LocalDateTime createdAt
) {
}
