package org.copper.manager.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MiningUnitRequest {
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    private Integer statusId;

    @NotBlank(message = "La URL del logo es requerida")
    private String urlLogo;
}
