package org.copper.manager.service.document;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.RoleCode;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.DocumentRequest;
import org.copper.manager.dto.response.DocumentResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.DocumentMapper;
import org.copper.manager.repository.DocumentRepository;
import org.copper.manager.service.common.context.ContextService;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final StatusService statusService;
    private final ContextService contextService;

    @Override
    public List<DocumentResponse> getAll() {
        String role = contextService.getCurrentUserRole();
        if (role == null) {
            throw new RequestException("No se encontró rol para el usuario");
        }
        return switch (RoleCode.valueOf(role)) {
            case ADMIN -> documentMapper.toResponseList(documentRepository.findAll());
            case USER, BASIC, PREMIUM -> {
                StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
                yield documentMapper.toResponseList(documentRepository.findAllByStatusId(status.id()));
            }
            default -> throw new RequestException("No tiene permisos para realizar esta acción");
        };
    }

    @Override
    public DocumentResponse create(DocumentRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return documentMapper.toResponse(
                documentRepository.save(documentMapper.toEntity(request)));
    }

    @Override
    public DocumentResponse update(Long id, DocumentRequest request) {
        if (!documentRepository.existsById(id)) {
            throw new RequestException("El documento con id " + id + "no exitste.");
        }
        request.setId(id);
        return documentMapper.toResponse(documentRepository
                .save(documentMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }
}
