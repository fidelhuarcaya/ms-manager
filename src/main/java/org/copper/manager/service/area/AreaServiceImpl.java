package org.copper.manager.service.area;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.AreaRequest;
import org.copper.manager.dto.response.AreaResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.Status;
import org.copper.manager.mapper.AreaMapper;
import org.copper.manager.repository.AreaRepository;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{
    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;
    private final StatusService statusService;

    @Override
    public List<AreaResponse> getAll() {
        return areaMapper.toResponseList(areaRepository.findAll());
    }

    @Override
    public AreaResponse create(AreaRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return areaMapper.toResponse(areaRepository.save(areaMapper.toEntity(request)));
    }


    @Override
    public AreaResponse update(Long id, AreaRequest request) {
        return areaMapper.toResponse(areaRepository.save(areaMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        areaRepository.deleteById(id);
    }



}
