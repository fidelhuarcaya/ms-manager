package org.copper.manager.service.topic;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.TopicRequest;
import org.copper.manager.dto.response.TopicResponse;
import org.copper.manager.entity.Topic;
import org.copper.manager.mapper.TopicMapper;
import org.copper.manager.repository.TopicRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl  extends AbstractEntityService<Topic, TopicResponse> implements TopicService {
    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Override
    public List<TopicResponse> getAll() {
        return topicMapper.toDtoList(topicRepository.findAll());
    }

    @Override
    public TopicResponse create(TopicRequest request) {
        return topicMapper.toDto(topicRepository.save(topicMapper.toEntity(request)));
    }

    @Override
    public TopicResponse update(Long id, TopicRequest request) {
        return topicMapper.toDto(topicRepository.save(topicMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    protected List<TopicResponse> mapToResponseList(List<Topic> entities) {
        return topicMapper.toDtoList(entities);
    }

    @Override
    protected List<TopicResponse> findAll() {
        return topicMapper.toDtoList(topicRepository.findAll());
    }

    @Override
    protected List<Topic> findAllByStatusId(Integer statusId) {
        return topicRepository.findAllByStatusId(statusId);
    }
}
