package org.copper.manager.service.common.context;

import org.copper.manager.entity.User;

public interface ContextService {
    User getCurrentUser();

    String getCurrentUserRole();
}
