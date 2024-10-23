package org.copper.manager.repository;

import org.copper.manager.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findAllByStatusId(Integer statusId);

    List<Equipment> findByAreaId(Integer areaId);
}
