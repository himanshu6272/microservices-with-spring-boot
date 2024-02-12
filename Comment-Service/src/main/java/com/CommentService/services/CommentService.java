package com.CommentService.services;

import com.CommentService.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment saveComment(Comment comment);
    List<Comment> getCommentsByPostId(String postId);
    List<Comment> getCommentsByUserId(String userId);
    List<Comment> getAllComments();
    void deleteComment(String commentId);
    Comment updateComment(Comment comment);
//    List<Comment> getCommentsByPostIdAndUserId(String postId, String userId);
    Comment getComment(String commentId);
//    void deleteCommentByPostIdAndUserId(String postId, String userId);
    void deleteCommentsByPostId(String postId);
    void deleteCommentsByUserId(String userId);
}
