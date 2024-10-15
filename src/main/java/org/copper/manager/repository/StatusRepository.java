package org.copper.manager.repository;


import org.copper.manager.common.StatusCode;
import org.copper.manager.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    Optional<Status> findByCode(StatusCode statusCode);

}