package org.copper.manager.service.resource.type;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.ResourceCode;
import org.copper.manager.dto.response.ResourceTypeResponse;
import org.copper.manager.entity.ResourceType;
import org.copper.manager.mapper.ResourceTypeMapper;
import org.copper.manager.repository.ResourceTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceTypeServiceImpl implements ResourceTypeService {
private final ResourceTypeRepository resourceTypeRepository;
private final ResourceTypeMapper resourceTypeMapper;

    @Override
    public ResourceTypeResponse findByCode(ResourceCode code) {
        return resourceTypeMapper.toDto(resourceTypeRepository.findByCode(code));
    }

    @Override
    public List<ResourceTypeResponse> findAll() {
        return resourceTypeMapper.toDtoList(resourceTypeRepository.findAll());
    }
}
