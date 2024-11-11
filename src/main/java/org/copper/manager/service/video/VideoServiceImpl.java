package org.copper.manager.service.video;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.request.VideoRequest;
import org.copper.manager.dto.response.VideoResponse;
import org.copper.manager.mapper.VideoMapper;
import org.copper.manager.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoMapper videoMapper;
    private final VideoRepository videoRepository;
    @Override
    public List<VideoResponse> getAll() {
        return videoMapper.toDtoList(videoRepository.findAll());
    }

    @Override
    public VideoResponse create(VideoRequest request) {
        return videoMapper.toDto(videoRepository.save(videoMapper.toEntity(request)));
    }

    @Override
    public VideoResponse update(Long id, VideoRequest request) {
        return videoMapper.toDto(videoRepository.save(videoMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        videoRepository.deleteById(id);
    }

}
