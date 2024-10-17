package org.copper.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DocumentResponse(
        Long id,
        String name,
        String url,
        CraftResponse craft,
        StatusResponse status,

        @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
        LocalDateTime createdAt
) {
}
