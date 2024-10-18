package org.copper.manager.mapper;

import org.copper.manager.dto.response.RoleResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.Role;
import org.copper.manager.entity.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    List<RoleResponse> toDtoList(List<Role> roleList);
    RoleResponse toResponse(Role role);
}
