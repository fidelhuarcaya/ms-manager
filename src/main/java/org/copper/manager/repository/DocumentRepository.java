package org.copper.manager.repository;

import org.copper.manager.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findAllByStatusId(Integer id);

    @Query("select d from Document d where d.craft.id = :craftId and d.status.code = 'ACTIVE'")
    List<Document> findByCraftId(@Param("craftId") Long craftId);
}