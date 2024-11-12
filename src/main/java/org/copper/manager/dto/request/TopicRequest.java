package org.copper.manager.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TopicRequest {
    private Long id;
    @NotBlank(message = "El nombre es requerido")
    private String name;
    private Long courseId;
    private Integer statusId;
}
