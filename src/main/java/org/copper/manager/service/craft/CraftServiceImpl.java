package org.copper.manager.service.craft;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.RoleCode;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.response.CraftResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.CraftMapper;
import org.copper.manager.repository.CraftRepository;
import org.copper.manager.service.common.context.ContextService;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CraftServiceImpl implements CraftService{
    private final CraftRepository craftRepository;
    private final CraftMapper craftMapper;
    private final StatusService statusService;
    private final ContextService contextService;

    @Override
    public List<CraftResponse> getAll() {
        String role = contextService.getCurrentUserRole();
        if (role == null) {
            throw new RequestException("No se encontró rol para el usuario");
        }
        return switch (RoleCode.valueOf(role)) {
            case ADMIN -> craftMapper.toResponseList(craftRepository.findAll());
            case USER, BASIC, PREMIUM-> {
                StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
                yield craftMapper.toResponseList(craftRepository.findAllByStatusId(status.id()));
            }
            default -> throw new RequestException("No tiene permisos para realizar esta acción");
        };
    }

    @Override
    public CraftResponse create(CraftRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return craftMapper.toResponse(
                craftRepository.save(craftMapper.toEntity(request)));
    }

    @Override
    public CraftResponse update(Long id, CraftRequest request) {
        if (!craftRepository.existsById(id)){
            throw new RequestException("No existe Manual con id: "+id);
        }
        request.setId(id);
        return craftMapper.toResponse(
                craftRepository.save(craftMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        craftRepository.deleteById(id);
    }
}
