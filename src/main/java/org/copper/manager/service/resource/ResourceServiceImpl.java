package org.copper.manager.service.resource;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.ResourceRequest;
import org.copper.manager.dto.response.ResourceTypeResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.dto.response.ResourceResponse;
import org.copper.manager.entity.Resource;
import org.copper.manager.entity.ResourceType;
import org.copper.manager.mapper.ResourceMapper;
import org.copper.manager.repository.ResourceRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.copper.manager.service.resource.type.ResourceTypeService;
import org.copper.manager.util.FileTypeUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl extends AbstractEntityService<Resource, ResourceResponse> implements ResourceService {
    private final ResourceMapper resourceMapper;
    private final ResourceRepository resourceRepository;
    private final ResourceTypeService resourceTypeService;

    @Override
    public List<ResourceResponse> getAll() {
        return resourceMapper.toDtoList(resourceRepository.findAll());
    }

    @Override
    public ResourceResponse create(ResourceRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        ResourceTypeResponse resourceTypeResponse = resourceTypeService
                .findByCode(FileTypeUtil.determineFileType(request.getUrl()));

        request.setResourceTypeId(resourceTypeResponse.getId());

        ResourceResponse response = resourceMapper.toDto(resourceRepository.save(resourceMapper.toEntity(request)));
        response.setResourceType(resourceTypeResponse);
        return response;
    }

    @Override
    public ResourceResponse update(Long id, ResourceRequest request) {
        return resourceMapper.toDto(resourceRepository.save(resourceMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public List<ResourceResponse> getByTopic(Long topicId) {
        return resourceMapper.toDtoList(resourceRepository.findByTopicId(topicId));
    }

    @Override
    protected List<ResourceResponse> mapToResponseList(List<Resource> entities) {
        return resourceMapper.toDtoList(entities);
    }

    @Override
    protected List<ResourceResponse> findAll() {
        return resourceMapper.toDtoList(resourceRepository.findAll());
    }

    @Override
    protected List<Resource> findAllByStatusId(Integer statusId) {
        return resourceRepository.findAllByStatusId(statusId);
    }
}
