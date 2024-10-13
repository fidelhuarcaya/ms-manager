package org.copper.manager.service.mining.unit;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;
import org.copper.manager.mapper.MiningUnitMapper;
import org.copper.manager.repository.MiningUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MiningUnitServiceImpl implements MiningUnitService {
    private final MiningUnitRepository miningUnitRepository;
    private final MiningUnitMapper miningUnitMapper;

    @Override
    public List<MiningUnitResponse> getAll() {
        return miningUnitRepository.findAll().stream().map(miningUnitMapper::toResponse)
                .toList();
    }

    @Override
    public MiningUnitResponse create(MiningUnitRequest request) {
        return miningUnitMapper.toResponse(miningUnitRepository.save(miningUnitMapper.toEntity(request)));
    }

    @Override
    public MiningUnitResponse update(Long id, MiningUnitRequest request) {
        return miningUnitMapper.toResponse(miningUnitRepository.save(miningUnitMapper.toEntity(request)));
    }
}
