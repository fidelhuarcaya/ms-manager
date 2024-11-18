package org.copper.manager.service.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String upload(MultipartFile file);
    byte[] download(String fileName);
    void delete(String fileUrl);
}
