package org.copper.manager.repository;

import org.copper.manager.common.ResourceCode;
import org.copper.manager.entity.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTypeRepository extends JpaRepository<ResourceType, Integer> {
    ResourceType findByCode(ResourceCode code);

}