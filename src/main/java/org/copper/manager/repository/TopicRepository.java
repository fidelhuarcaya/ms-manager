package org.copper.manager.repository;

import org.copper.manager.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByStatusId(@Param("statusId") Integer statusId);

    @Query("select t from Topic t where t.course.id = :courseId and t.status.code = 'ACTIVE'")
    List<Topic> findTopicsByCourseId(@Param("courseId") Long id);
}