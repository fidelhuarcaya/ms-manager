package org.copper.manager.service.status;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.StatusMapper;
import org.copper.manager.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService{
private final StatusRepository statusRepository;
private final StatusMapper statusMapper;
    @Override
    public List<StatusResponse> getAll() {
        return statusMapper.toDtoList(statusRepository.findAll());
    }

    @Override
    public StatusResponse findByCode(StatusCode statusCode) {
        return statusMapper
                .toResponse(statusRepository.findByCode(statusCode)
                .orElseThrow(() -> new RequestException("No existe estado con código "+statusCode.name())));
    }
}
