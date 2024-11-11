package org.copper.manager.mapper;

import org.copper.manager.dto.request.VideoRequest;
import org.copper.manager.dto.response.VideoResponse;
import org.copper.manager.entity.Video;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoMapper {
    Video toEntity(VideoRequest request);
    VideoResponse toDto(Video Video);
    List<VideoResponse> toDtoList(List<Video> VideoList);
}