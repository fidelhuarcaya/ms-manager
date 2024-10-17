package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class DocumentRequest {
    private Long id;
    private String name;
    private String url;
    private Long craftId;
    private Integer statusId;
}
