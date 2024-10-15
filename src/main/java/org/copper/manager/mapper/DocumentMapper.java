package org.copper.manager.mapper;

import org.copper.manager.dto.request.DocumentRequest;
import org.copper.manager.dto.response.DocumentResponse;
import org.copper.manager.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentMapper {
    Document toEntity(DocumentRequest request);

    DocumentResponse toResponse(Document document);

}