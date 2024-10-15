package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class AreaRequest {
private Long id;
private String name;
private Long miningUnitId;
private Integer statusId;
}
