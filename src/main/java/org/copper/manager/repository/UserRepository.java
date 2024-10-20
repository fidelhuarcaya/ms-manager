package org.copper.manager.repository;

import org.copper.manager.common.StatusCode;
import org.copper.manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    long countByStatusCode(StatusCode statusCode);

    @Query("SELECT r.code, COUNT(u) FROM User u JOIN u.userRoles ur JOIN ur.role r GROUP BY r.code")
    List<Object[]> countUsersByRole();
}
