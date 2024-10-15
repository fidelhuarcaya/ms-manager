package org.copper.manager.mapper;

import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    List<StatusResponse> toDtoList(List<Status> statusList);
    StatusResponse toResponse(Status status);
}
