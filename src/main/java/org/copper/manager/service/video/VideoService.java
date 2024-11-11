package org.copper.manager.service.video;

import org.copper.manager.dto.request.VideoRequest;
import org.copper.manager.dto.response.VideoResponse;

import java.util.List;

public interface VideoService {
    List<VideoResponse> getAll();

    VideoResponse create(VideoRequest request);

    VideoResponse update(Long id, VideoRequest request);

    void delete(Long id);
}