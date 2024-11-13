package org.copper.manager.dto.request;

import lombok.Data;
@Data
public class VideoRequest {
    private Long id;
    private String title;
    private String url;
    private Long topicId;
    private Integer statusId;
}
