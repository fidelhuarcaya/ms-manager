package org.copper.manager.repository;

import org.copper.manager.entity.Craft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CraftRepository extends JpaRepository<Craft, Long> {
    List<Craft> findAllByStatusId(Integer id);

    @Query("select c from Craft c where c.equipment.id = :equipmentId and c.status.code = 'ACTIVE'")
    List<Craft> findByEquipmentId(Integer equipmentId);
}