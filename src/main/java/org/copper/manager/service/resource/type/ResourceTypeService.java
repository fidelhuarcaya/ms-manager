package org.copper.manager.service.resource.type;

import org.copper.manager.common.ResourceCode;
import org.copper.manager.dto.response.ResourceTypeResponse;
import org.copper.manager.entity.ResourceType;

import java.util.List;

public interface ResourceTypeService {
    ResourceTypeResponse findByCode(ResourceCode code);
    List<ResourceTypeResponse> findAll();
}
