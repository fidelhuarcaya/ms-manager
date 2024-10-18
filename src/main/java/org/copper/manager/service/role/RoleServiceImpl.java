package org.copper.manager.service.role;

import lombok.RequiredArgsConstructor;
import org.copper.manager.common.RoleCode;
import org.copper.manager.dto.response.RoleResponse;
import org.copper.manager.exception.RequestException;
import org.copper.manager.mapper.RoleMapper;
import org.copper.manager.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponse> getAll() {
        return roleMapper.toDtoList(roleRepository.findAll());
    }

    @Override
    public RoleResponse findByCode(RoleCode statusCode) {
        return roleMapper
                .toResponse(roleRepository.findByCode(statusCode)
                        .orElseThrow(() -> new RequestException("No existe estado con código " + statusCode.name())));
    }
}
