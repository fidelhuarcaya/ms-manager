package org.copper.manager.dto.request;

import lombok.Data;

@Data
public class CourseRequest {
    private Long id;
    private String name;
    private String banner;
    private String description;
    private Integer statusId;
}
