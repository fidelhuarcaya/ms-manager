package org.copper.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AreaResponse(
        Long id,
        String name,
        MiningUnitResponse miningUnit,
        StatusResponse status,

        @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
        LocalDateTime createdAt
) {
}
