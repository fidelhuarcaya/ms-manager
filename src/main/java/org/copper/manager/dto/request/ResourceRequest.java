package org.copper.manager.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.copper.manager.common.ResourceCode;
import org.copper.manager.entity.ResourceType;

@Data
public class ResourceRequest {
    private Long id;

    @NotBlank(message = "El título es requerido")
    private String title;

    @NotBlank(message = "La descripción es requerida")
    private String url;
    private Long topicId;
    private Integer statusId;

    private Integer resourceTypeId;
}
