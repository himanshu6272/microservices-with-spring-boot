package com.CommentService.repositories;

import com.CommentService.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    @Query("SELECT c FROM Comment c WHERE c.postId = :postId")
    List<Comment> getCommentsByPostId(@Param("postId") String postId);

    @Query("SELECT c FROM Comment c WHERE c.userId = :userId")
    List<Comment> getCommentsByUserId(@Param("userId") String userId);

//    @Query("SELECT c FROM Comment c WHERE c.userId = :userId AND c.postId = :postId")
//    List<Comment> getCommentsByPostIdAndUserId(@Param("postId") String postId, @Param("userId") String userId);

//    @Query("DELETE FROM Comment c WHERE c.postId = :postId AND c.userId = :userId")
//    void deleteCommentByPostIdAndUserId(@Param("postId") String postId, @Param("userId") String userId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Comment c WHERE c.postId = :postId")
    void deleteCommentsByPostId(@Param("postId") String postId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Comment c WHERE c.userId = :userId")
    void deleteCommentsByUserId(@Param("userId") String userId);
}
