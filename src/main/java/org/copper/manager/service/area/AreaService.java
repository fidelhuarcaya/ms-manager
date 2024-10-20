package org.copper.manager.service.area;

import org.copper.manager.dto.request.AreaRequest;
import org.copper.manager.dto.response.AreaResponse;

import java.util.List;

public interface AreaService {

    List<AreaResponse> getAll();

    AreaResponse create(AreaRequest request);

    AreaResponse update(Integer id, AreaRequest request);

    void delete(Integer id);
}
