package org.copper.manager.service.equipment;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.EquipmentRequest;
import org.copper.manager.dto.response.EquipmentResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.EquipmentMapper;
import org.copper.manager.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    @Override
    public List<EquipmentResponse> getAll() {
        return equipmentRepository
                .findAll().stream().map(equipmentMapper::toResponse).toList();
    }

    @Override
    public EquipmentResponse create(EquipmentRequest request) {
        return equipmentMapper.toResponse(
                equipmentRepository.save(equipmentMapper.toEntity(request)));
    }

    @Override
    public EquipmentResponse update(Long id, EquipmentRequest request) {
        if (!equipmentRepository.existsById(id)) {
            throw new RequestException("El equipo con id: " + id + " no existe.");
        }
        return create(request);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}
