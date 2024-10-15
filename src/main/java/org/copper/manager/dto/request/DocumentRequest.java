package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class DocumentRequest {
    private Long id;
    private String name;
    private Long CraftId;
    private Integer statusId;
}
