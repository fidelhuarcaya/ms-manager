package org.copper.manager.service.craft;

import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.response.CraftResponse;

import java.util.List;

public interface CraftService {
    List<CraftResponse> getAll();

    CraftResponse create(CraftRequest request);

    CraftResponse update(Long id, CraftRequest request);

    void delete(Long id);
}
