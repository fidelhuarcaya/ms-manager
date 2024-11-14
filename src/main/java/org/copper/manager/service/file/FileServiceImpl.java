package org.copper.manager.service.file;

import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${google.cloud.storage.bucket}")
    private String bucketName;
    private final Storage storage = StorageOptions.getDefaultInstance().getService();

    @Override
    public String upload(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            Assert.notNull(fileName, "El archivo no tiene un nombre.");
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
            storage.create(blobInfo, file.getBytes());

            return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }

    @Override
    public byte[] download(String fileName) {
        BlobId blobId = BlobId.of(bucketName, fileName);
        return storage.readAllBytes(blobId);
    }
}

