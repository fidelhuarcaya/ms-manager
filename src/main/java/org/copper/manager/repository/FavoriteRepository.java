package org.copper.manager.repository;

import org.copper.manager.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserEmail(String email);

    @Transactional
    @Modifying
    @Query("delete from Favorite f where f.user.email = :email and f.id = :favoriteId")
    void deleteByUserIdAndFavoriteId(@Param("email") String email, @Param("favoriteId") Long favoriteId);
}