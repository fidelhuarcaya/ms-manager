package org.copper.manager.dto.response;

import lombok.Data;
import org.copper.manager.common.ResourceCode;

@Data
public class ResourceTypeResponse {
    private Integer id;
    private String description;
    private ResourceCode code;
}
