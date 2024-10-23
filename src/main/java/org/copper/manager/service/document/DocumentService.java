package org.copper.manager.service.document;

import org.copper.manager.dto.request.DocumentRequest;
import org.copper.manager.dto.response.DocumentResponse;

import java.util.List;

public interface DocumentService {
    List<DocumentResponse> getAll();

    DocumentResponse create(DocumentRequest request);

    DocumentResponse update(Long id, DocumentRequest request);

    void delete(Long id);

    List<DocumentResponse> getByCraftId(Long craftId);
}
