package org.copper.manager.service.craft;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.copper.manager.common.RoleCode;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.response.CraftResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.Craft;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.CraftMapper;
import org.copper.manager.repository.CraftRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.copper.manager.service.common.context.ContextService;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CraftServiceImpl extends AbstractEntityService<Craft, CraftResponse> implements CraftService{
    private final CraftRepository craftRepository;
    private final CraftMapper craftMapper;
    private final StatusService statusService;

    @Override
    public List<CraftResponse> findAll() {
        return craftMapper.toResponseList(craftRepository.findAll());
    }

    @Override
    @Transactional
    public CraftResponse create(CraftRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return craftMapper.toResponse(
                craftRepository.save(craftMapper.toEntity(request)));
    }

    @Override
    @Transactional
    public CraftResponse update(Long id, CraftRequest request) {
        if (!craftRepository.existsById(id)){
            throw new RequestException("No existe Manual con id: "+id);
        }
        request.setId(id);
        return craftMapper.toResponse(
                craftRepository.save(craftMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        craftRepository.deleteById(id);
    }

    @Override
    protected List<Craft> findAllByStatusId(Integer statusId) {
        return craftRepository.findAllByStatusId(statusId);
    }

    @Override
    protected List<CraftResponse> mapToResponseList(List<Craft> entities) {
        return craftMapper.toResponseList(entities);
    }
}
