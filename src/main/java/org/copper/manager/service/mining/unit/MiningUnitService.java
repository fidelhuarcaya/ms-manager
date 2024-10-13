package org.copper.manager.service.mining.unit;

import org.copper.manager.dto.request.MiningUnitRequest;
import org.copper.manager.dto.response.MiningUnitResponse;

public interface MiningUnitService {

    MiningUnitResponse create(MiningUnitRequest request);

    MiningUnitResponse update(Long id, MiningUnitRequest request);

    MiningUnitResponse getAll();
}
