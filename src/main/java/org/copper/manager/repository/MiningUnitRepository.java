package org.copper.manager.repository;

import org.copper.manager.entity.MiningUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiningUnitRepository extends JpaRepository<MiningUnit, Long> {
}
