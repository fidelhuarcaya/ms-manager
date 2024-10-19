package org.copper.manager.repository;

import org.copper.manager.entity.Craft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CraftRepository extends JpaRepository<Craft, Long> {
    List<Craft> findAllByStatusId(Integer id);
}