package org.copper.manager.repository;

import org.copper.manager.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    Object findAllByStatusId(Integer id);
}