package org.copper.manager.repository;

import org.copper.manager.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

    List<Area> findAllByStatusId(Integer statusId);

    @Query("select a from Area a where a.miningUnit.id = :miningUnitId and a.status.code = 'ACTIVE'")
    List<Area> findByMiningUnitId(@Param("miningUnitId") Long miningUnitId);
}
