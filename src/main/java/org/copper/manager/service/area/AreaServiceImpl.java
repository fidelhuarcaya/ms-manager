package org.copper.manager.service.area;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.AreaRequest;
import org.copper.manager.dto.response.AreaResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.Area;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.AreaMapper;
import org.copper.manager.repository.AreaRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.copper.manager.service.common.context.ContextService;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import org.copper.manager.common.RoleCode;

import java.util.List;

@Service
@SuperBuilder
public class AreaServiceImpl extends AbstractEntityService<Area, AreaResponse> implements AreaService {
    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    @Override
    protected List<Area> findAll() {
        return areaRepository.findAll();
    }


    @Override
    public AreaResponse create(AreaRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return areaMapper.toResponse(areaRepository.save(areaMapper.toEntity(request)));
    }


    @Override
    public AreaResponse update(Long id, AreaRequest request) {
        if (!areaRepository.existsById(id)) {
            throw new RequestException("El área seleccionada con id: " + id+" no existe.");
        }
        request.setId(id);
        return areaMapper.toResponse(areaRepository
                .save(areaMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        areaRepository.deleteById(id);
    }

    @Override
    protected List<AreaResponse> mapToResponseList(List<Area> entities) {
        return areaMapper.toResponseList(entities);
    }

    @Override
    protected List<Area> findAllByStatusId(Integer statusId) {
        return areaRepository.findAllByStatusId(statusId);
    }

}
