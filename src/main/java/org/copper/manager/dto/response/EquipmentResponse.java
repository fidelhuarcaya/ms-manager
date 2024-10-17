package org.copper.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record EquipmentResponse(
        Long id,
        String name,
        AreaResponse area,
        StatusResponse status,

        @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
        LocalDateTime createdAt
) {
}
