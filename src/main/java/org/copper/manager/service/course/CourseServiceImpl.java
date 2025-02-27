package org.copper.manager.service.course;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.request.CourseRequest;
import org.copper.manager.dto.response.CourseResponse;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.entity.Course;
import org.copper.manager.mapper.CourseMapper;
import org.copper.manager.repository.CourseRepository;
import org.copper.manager.service.common.basic.AbstractEntityService;
import org.copper.manager.service.status.StatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends AbstractEntityService<Course, CourseResponse> implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final StatusService statusService;

    @Override
    protected List<CourseResponse> mapToResponseList(List<Course> entities) {
        return courseMapper.toDtoList(entities);
    }

    @Override
    public List<CourseResponse> findAll() {
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    @Override
    protected List<Course> findAllByStatusId(Integer statusId) {
        return courseRepository.findAllByStatusId(statusId);
    }

    @Override
    public CourseResponse getById(Long id) {
        return courseMapper.toDto(courseRepository.findById(id).orElse(null));
    }

    @Override
    public CourseResponse create(CourseRequest request) {
        StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
        request.setStatusId(status.id());
        return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(request)));
    }

    @Override
    public CourseResponse update(Long id, CourseRequest request) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("El curso con id: " + id + " no existe.");
        }
        request.setId(id);
        return courseMapper.toDto(courseRepository.save(courseMapper.toEntity(request)));
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
