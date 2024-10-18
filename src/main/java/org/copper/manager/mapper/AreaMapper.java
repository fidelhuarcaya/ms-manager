package org.copper.manager.mapper;

import org.copper.manager.dto.request.AreaRequest;
import org.copper.manager.dto.response.AreaResponse;
import org.copper.manager.entity.Area;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    AreaResponse toResponse(Area entity);

    List<AreaResponse> toResponseList(List<Area> entities);

    @Mapping(target = "miningUnit.id", source = "miningUnitId")
    @Mapping(target = "status.id", source = "statusId")
    Area toEntity(AreaRequest request);
}
