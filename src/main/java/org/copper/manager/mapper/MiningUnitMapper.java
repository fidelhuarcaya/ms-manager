package org.copper.manager.mapper;


import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;
import org.copper.manager.entity.MiningUnit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MiningUnitMapper {

    MiningUnit toEntity(MiningUnitRequest request);

    MiningUnitResponse toResponse(MiningUnit entity);
}
