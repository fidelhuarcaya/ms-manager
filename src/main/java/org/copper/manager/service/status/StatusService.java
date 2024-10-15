package org.copper.manager.service.status;


import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.response.StatusResponse;

import java.util.List;

public interface StatusService {
    List<StatusResponse> getAll();
    StatusResponse findByCode(StatusCode statusCode);
}
