package org.copper.manager.service.document;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.CraftRequest;
import org.copper.manager.dto.request.DocumentRequest;
import org.copper.manager.dto.response.CraftResponse;
import org.copper.manager.dto.response.DocumentResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.DocumentMapper;
import org.copper.manager.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
private final DocumentRepository documentRepository;
private final DocumentMapper documentMapper;


    @Override
    public List<DocumentResponse> getAll() {
        return documentRepository.findAll().stream().map(documentMapper::toResponse).toList();
    }

    @Override
    public DocumentResponse create(DocumentRequest request) {
        return documentMapper.toResponse(
                documentRepository.save(documentMapper.toEntity(request)));
    }

    @Override
    public DocumentResponse update(Long id, DocumentRequest request) {
        if (!documentRepository.existsById(id)){
            throw new RequestException("El documento con id "+ id + "no exitste.");
        }
        request.setId(id);
        return create(request);
    }

    @Override
    public void delete(Long id) {
    documentRepository.deleteById(id);
    }
}
