package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class TopicRequest {
    private Long id;
    private String name;
    private String banner;
    private Integer statusId;
}
