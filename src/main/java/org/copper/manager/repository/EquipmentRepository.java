package org.copper.manager.repository;

import org.copper.manager.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findAllByStatusId( @Param("statusId") Integer statusId);

    @Query("select e from Equipment e where e.area.id = :areaId and e.status.code = 'ACTIVE'")
    List<Equipment> findByAreaId(@Param("areaId") Integer areaId);
}
