package org.copper.manager.repository;

import org.copper.manager.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    List<Area> findAllByStatusId(Integer statusId);
}
