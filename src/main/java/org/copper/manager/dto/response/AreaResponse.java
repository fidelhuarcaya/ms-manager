package org.copper.manager.dto.response;

import java.time.LocalDateTime;

public record AreaResponse(
        Integer id,
        String name,
        MiningUnitResponse miningUnit,
        StatusResponse status,
        LocalDateTime createdAt
) {
}
