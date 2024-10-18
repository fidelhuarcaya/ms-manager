package org.copper.manager.service.role;

import org.copper.manager.common.RoleCode;
import org.copper.manager.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAll();
    RoleResponse findByCode(RoleCode code);
}
