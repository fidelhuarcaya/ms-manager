package org.copper.manager.dto.response;

import java.time.LocalDateTime;

public record CraftResponse(
        Integer id,
        String name,
        MiningUnitResponse miningUnit,
        StatusResponse status,
        LocalDateTime createdAt
) {
}
