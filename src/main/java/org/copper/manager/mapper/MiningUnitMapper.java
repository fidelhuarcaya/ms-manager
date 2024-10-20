package org.copper.manager.mapper;


import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;
import org.copper.manager.entity.MiningUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MiningUnitMapper {

    @Mapping(target = "status.id", source = "statusId")
    MiningUnit toEntity(MiningUnitRequest request);

    MiningUnitResponse toResponse(MiningUnit entity);

    List<MiningUnitResponse> toResponseList(List<MiningUnit> all);
}
