package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class CraftRequest {
    private Long id;
    private String name;
    private Long equipmentId;
    private Integer statusId;
}
