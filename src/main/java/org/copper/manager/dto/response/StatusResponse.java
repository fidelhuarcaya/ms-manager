package org.copper.manager.dto.response;

import org.copper.manager.common.StatusCode;

public record StatusResponse(
    Integer id,
    StatusCode code,
    String description
) {
}
