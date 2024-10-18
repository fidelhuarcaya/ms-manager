package org.copper.manager.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MiningUnitResponse{
    private Long id;

    private String name;

    private String urlLogo;

    private StatusResponse status;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;
}
