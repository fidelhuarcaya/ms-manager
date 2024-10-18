package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class EquipmentRequest {
    private Long id;
    private String name;
    private Long areaId;
    private Integer statusId;
}
