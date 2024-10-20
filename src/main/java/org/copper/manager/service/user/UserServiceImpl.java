package org.copper.manager.service.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.copper.manager.common.RoleCode;
import org.copper.manager.common.StatusCode;
import org.copper.manager.dto.response.ReportResponse;
import org.copper.manager.repository.RoleRepository;
import org.copper.manager.repository.StatusRepository;
import org.copper.manager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ReportResponse generateReport() {
        long activeUsers = userRepository.countByStatusCode(StatusCode.ACTIVE);
        long inactiveUsers = userRepository.countByStatusCode(StatusCode.INACTIVE);

        List<Object[]> usersPerRole = userRepository.countUsersByRole();

        // Crear un mapa con todos los posibles roles y sus conteos, iniciando en 0 por defecto
        Map<String, Long> usersPerRoleMap = Arrays.stream(RoleCode.values())  // Recorre todos los roles posibles
                .collect(Collectors.toMap(
                        RoleCode::name,  // Llave: Nombre del enum RoleCode
                        role -> 0L       // Valor inicial: 0 para cada rol
                ));

        // Actualizar el mapa con los resultados de la consulta
        usersPerRole.forEach(result ->
                usersPerRoleMap.put(((RoleCode) result[0]).name(), (Long) result[1])
        );

        return ReportResponse.builder()
                .activeUsers(activeUsers)
                .inactiveUsers(inactiveUsers)
                .usersPerRole(usersPerRoleMap)
                .build();


    }
}
