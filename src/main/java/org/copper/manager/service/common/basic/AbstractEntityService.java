package org.copper.manager.service.common.basic;

import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.copper.manager.common.RoleCode;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.response.StatusResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.service.common.context.ContextService;
import org.copper.manager.service.status.StatusService;

import java.util.List;
@RequiredArgsConstructor
@SuperBuilder
public abstract class AbstractEntityService<T, R> {
    protected final StatusService statusService;
    protected final ContextService contextService;

    protected abstract List<R> mapToResponseList(List<T> entities);
    protected abstract List<T> findAll();
    protected abstract List<T> findAllByStatusId(Integer statusId);

    public List<R> getAll() {
        String role = contextService.getCurrentUserRole();
        if (role == null) {
            throw new RequestException("No se encontró rol para el usuario");
        }
        return switch (RoleCode.valueOf(role)) {
            case ADMIN -> mapToResponseList(findAll());
            case USER, BASIC, PREMIUM -> {
                StatusResponse status = statusService.findByCode(StatusCode.ACTIVE);
                yield mapToResponseList(findAllByStatusId(status.id()));
            }
            default -> throw new RequestException("No tiene permisos para realizar esta acción");
        };
    }
}
