package org.copper.manager.mapper;

import org.copper.manager.dto.request.DocumentRequest;
import org.copper.manager.dto.response.DocumentResponse;
import org.copper.manager.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DocumentMapper {
    @Mapping(target = "craft.id", source = "craftId")
    @Mapping(target = "status.id", source = "statusId")
    Document toEntity(DocumentRequest request);

    DocumentResponse toResponse(Document document);

    List<DocumentResponse> toResponseList(Object allByStatusId);
}