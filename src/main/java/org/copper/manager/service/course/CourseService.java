package org.copper.manager.service.course;

import org.copper.manager.dto.request.CourseRequest;
import org.copper.manager.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    List<CourseResponse> getAll();

    CourseResponse getById(Long id);

    CourseResponse create(CourseRequest request);

    CourseResponse update(Long id, CourseRequest request);

    void delete(Long id);
}
