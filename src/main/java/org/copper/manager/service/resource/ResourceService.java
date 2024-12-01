package org.copper.manager.service.resource;

import org.copper.manager.dto.request.ResourceRequest;
import org.copper.manager.dto.response.ResourceResponse;

import java.util.List;

public interface ResourceService {
    List<ResourceResponse> getAll();

    ResourceResponse create(ResourceRequest request);

    ResourceResponse update(Long id, ResourceRequest request);

    void delete(Long id);

    List<ResourceResponse> getByTopic(Long topicId);
}