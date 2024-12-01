package org.copper.manager.repository;

import org.copper.manager.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query("select v from Resource v where v.topic.id = :topicId")
    List<Resource> findByTopicId(@Param("topicId") Long topicId);

    List<Resource> findAllByStatusId(Integer statusId);
}