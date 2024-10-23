package org.copper.manager.service.equipment;

import org.copper.manager.dto.request.EquipmentRequest;
import org.copper.manager.dto.response.EquipmentResponse;

import java.util.List;

public interface EquipmentService {
    List<EquipmentResponse> getAll();

    EquipmentResponse create(EquipmentRequest request);

    EquipmentResponse update(Long id, EquipmentRequest request);

    void delete(Long id);

    List<EquipmentResponse> getByAreaId(Integer areaId);
}
