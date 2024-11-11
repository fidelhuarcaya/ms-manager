package org.copper.manager.dto.response;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;


@Data
public class TopicResponse{
    private Long id;
    private String name;
    private String banner;
}