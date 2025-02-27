package org.copper.manager.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class FavoriteRequest {
    private Long id;
    private Long userId;
    @NotNull(message = "El documento es requerido")
    private Long documentId;
}
