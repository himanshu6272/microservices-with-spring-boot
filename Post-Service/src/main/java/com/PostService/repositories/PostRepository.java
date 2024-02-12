package com.PostService.repositories;

import com.PostService.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    @Query("SELECT p FROM Post p WHERE p.userId = :userId")
    List<Post> getPostsByUserId(@Param("userId") String userId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Post p WHERE p.userId = :userId")
    void deletePostsByUserId(String userId);
}
