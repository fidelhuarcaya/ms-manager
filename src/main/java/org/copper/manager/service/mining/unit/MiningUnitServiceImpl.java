package org.copper.manager.service.mining.unit;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.MiningUnit;
import org.copper.manager.mapper.MiningUnitMapper;
import org.copper.manager.repository.MiningUnitRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MiningUnitServiceImpl extends AbstractEntityService<MiningUnit, MiningUnitResponse> implements MiningUnitService {
    private final MiningUnitRepository miningUnitRepository;
    private final MiningUnitMapper miningUnitMapper;
    private final StatusService statusService;

    @Override
    public List<MiningUnitResponse> findAll() {
        return miningUnitMapper.toResponseList(miningUnitRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        miningUnitRepository.deleteById(id);
    }

    @Override
    public MiningUnitResponse create(MiningUnitRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return miningUnitMapper.toResponse(miningUnitRepository.save(miningUnitMapper.toEntity(request)));
    }

    @Override
    public MiningUnitResponse update(Long id, MiningUnitRequest request) {
        if (!miningUnitRepository.existsById(id)){
            throw new RuntimeException("Unidad minera no encontrada");
        }
        request.setId(id);
        return miningUnitMapper.toResponse(miningUnitRepository
                .save(miningUnitMapper.toEntity(request)));
    }
    @Override
    protected List<MiningUnitResponse> mapToResponseList(List<MiningUnit> entities) {
        return miningUnitMapper.toResponseList(entities);
    }
    @Override
    protected List<MiningUnit> findAllByStatusId(Integer statusId) {
        return miningUnitRepository.findAllByStatusId(statusId);
    }
}
