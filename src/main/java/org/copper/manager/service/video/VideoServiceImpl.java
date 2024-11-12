package org.copper.manager.service.video;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.VideoRequest;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.dto.response.VideoResponse;
import org.copper.manager.entity.Video;
import org.copper.manager.mapper.VideoMapper;
import org.copper.manager.repository.VideoRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl extends AbstractEntityService<Video, VideoResponse> implements VideoService {
    private final VideoMapper videoMapper;
    private final VideoRepository videoRepository;

    @Override
    public List<VideoResponse> getAll() {
        return videoMapper.toDtoList(videoRepository.findAll());
    }

    @Override
    public VideoResponse create(VideoRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
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

    @Override
    public List<VideoResponse> getByTopic(Long topicId) {
        return videoMapper.toDtoList(videoRepository.findByTopicId(topicId));
    }

    @Override
    protected List<VideoResponse> mapToResponseList(List<Video> entities) {
        return videoMapper.toDtoList(entities);
    }

    @Override
    protected List<VideoResponse> findAll() {
        return videoMapper.toDtoList(videoRepository.findAll());
    }

    @Override
    protected List<Video> findAllByStatusId(Integer statusId) {
        return videoRepository.findAllByStatusId(statusId);
    }
}
