package org.copper.manager.mapper;

import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.response.CraftResponse;
import org.copper.manager.entity.Craft;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CraftMapper {
    @Mapping(target = "equipment.id", source = "equipmentId")
    @Mapping(target = "status.id", source = "statusId")
    Craft toEntity(CraftRequest request);

    CraftResponse toResponse(Craft craft);
}