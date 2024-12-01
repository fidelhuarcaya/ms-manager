package org.copper.manager.dto.response;

import lombok.Data;

@Data
public class ResourceResponse {
    private Long id;
    private String title;
    private String url;
    private ResourceTypeResponse resourceType;
}
