package org.copper.manager.mapper;

import org.copper.manager.dto.request.ResourceRequest;
import org.copper.manager.dto.response.ResourceResponse;
import org.copper.manager.entity.Resource;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ResourceMapper {
    @Mapping(target = "status.id", source = "statusId")
    @Mapping(target = "topic.id", source = "topicId")
    @Mapping(target = "resourceType.id", source = "resourceTypeId")
    Resource toEntity(ResourceRequest request);

    @Mapping(target = "resourceType.code", source = "resourceType.code")
    @Mapping(target = "resourceType.id", source = "resourceType.id")
    ResourceResponse toDto(Resource resource);

    List<ResourceResponse> toDtoList(List<Resource> resourceList);
}