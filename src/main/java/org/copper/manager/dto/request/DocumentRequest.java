package org.copper.manager.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class DocumentRequest {
    private Long id;
    private String name;
    private String url;
    private Long craftId;
    private Integer statusId;
    private List<MultipartFile> files ;
}
