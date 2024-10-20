package org.copper.manager.service.report;

import lombok.RequiredArgsConstructor;
import org.copper.manager.dto.response.ReportResponse;
import org.copper.manager.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
private final UserService userService;

    @Override
    public ReportResponse generateReport() {
        return userService.generateReport();
    }
}
