package org.copper.manager.dto.request;

import lombok.Data;
@Data
public class VideoRequest {
    private Long id;
    private String name;
    private String url;
    private Long topicId;
    private Integer statusId;
}
