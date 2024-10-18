package org.copper.manager.service.equipment;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.EquipmentRequest;
import org.copper.manager.dto.response.EquipmentResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.EquipmentMapper;
import org.copper.manager.repository.EquipmentRepository;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;
    private final StatusService statusService;

    @Override
    public List<EquipmentResponse> getAll() {
        return equipmentRepository
                .findAll().stream().map(equipmentMapper::toResponse).toList();
    }

    @Override
    public EquipmentResponse create(EquipmentRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return equipmentMapper.toResponse(
                equipmentRepository.save(equipmentMapper.toEntity(request)));
    }

    @Override
    public EquipmentResponse update(Long id, EquipmentRequest request) {
        if (!equipmentRepository.existsById(id)) {
            throw new RequestException("El equipo con id: " + id + " no existe.");
        }
        request.setId(id);
        return equipmentMapper.toResponse(
                equipmentRepository.save(equipmentMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}
