package org.copper.manager.service.topic;

import org.copper.manager.dto.request.TopicRequest;
import org.copper.manager.dto.response.TopicResponse;

import java.util.List;

public interface TopicService {
    List<TopicResponse> getAll();

    TopicResponse create(TopicRequest request);

    TopicResponse update(Long id, TopicRequest request);

    void delete(Long id);

    TopicResponse getById(Long id);
}