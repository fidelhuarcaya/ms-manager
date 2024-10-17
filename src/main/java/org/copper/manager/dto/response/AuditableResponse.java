package org.copper.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;


public class AuditableResponse{
        private LocalDateTime createdAt;
        @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")

        private LocalDateTime updatedAt;

        private String createdBy;

        private String updatedBy;

}
