package org.copper.manager.dto.response;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;


public class AuditableResponse{
        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

        private String createdBy;

        private String updatedBy;

}
