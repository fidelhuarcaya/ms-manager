package org.copper.manager.service.mining.unit;

import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;

import java.util.List;

public interface MiningUnitService {

    MiningUnitResponse create(MiningUnitRequest request);

    MiningUnitResponse update(Long id, MiningUnitRequest request);

    List<MiningUnitResponse> getAll();
}
