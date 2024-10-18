package org.copper.manager.dto.response;

import org.copper.manager.common.RoleCode;

public record RoleResponse(
        Integer id,
        RoleCode code,
        String description
) {
}
