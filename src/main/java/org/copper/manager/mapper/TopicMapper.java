package org.copper.manager.mapper;

import org.copper.manager.dto.request.TopicRequest;
import org.copper.manager.dto.response.TopicResponse;
import org.copper.manager.entity.Topic;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TopicMapper {
    @Mapping(target = "status.id", source = "statusId")
    @Mapping(target = "course.id", source = "courseId")
    Topic toEntity(TopicRequest request);
    TopicResponse toDto(Topic topic);
    List<TopicResponse> toDtoList(List<Topic> topicList);

}