package org.copper.manager.mapper;

import org.copper.manager.dto.request.CourseRequest;
import org.copper.manager.dto.response.CourseResponse;
import org.copper.manager.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "status.id", source = "statusId")
    Course toEntity(CourseRequest request);
    CourseResponse toDto(Course Course);
    List<CourseResponse> toDtoList(List<Course> CourseList);
}
