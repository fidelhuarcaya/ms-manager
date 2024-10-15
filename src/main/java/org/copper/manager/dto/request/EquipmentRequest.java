package org.copper.manager.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.copper.manager.entity.Area;
import org.copper.manager.entity.Status;

@Data
public class EquipmentRequest {
    private Integer id;
    private String name;
    private Long areaId;
    private Integer statusId;
}
