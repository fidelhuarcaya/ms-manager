package org.copper.manager.mapper;

import org.copper.manager.dto.response.ResourceTypeResponse;
import org.copper.manager.entity.ResourceType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResourceTypeMapper {

    ResourceTypeResponse toDto(ResourceType resourceType);

    List<ResourceTypeResponse> toDtoList(List<ResourceType> all);
}
