package org.copper.manager.service.document;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.DocumentRequest;
import org.copper.manager.dto.response.DocumentResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.DocumentMapper;
import org.copper.manager.repository.DocumentRepository;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;
    private final StatusService statusService;


    @Override
    public List<DocumentResponse> getAll() {
        return documentRepository.findAll().stream().map(documentMapper::toResponse).toList();
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
