package org.copper.manager.repository;

import org.copper.manager.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query("select v from Video v where v.topic.id = :topicId")
    List<Video> findByTopicId(@Param("topicId") Long topicId);

    List<Video> findAllByStatusId(Integer statusId);
}