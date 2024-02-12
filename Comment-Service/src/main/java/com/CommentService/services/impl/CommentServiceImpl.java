package com.CommentService.services.impl;

import com.CommentService.entities.Comment;
import com.CommentService.repositories.CommentRepository;
import com.CommentService.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment saveComment(Comment comment) {
        String commentId = "comment-" + UUID.randomUUID();
        comment.setCommentId(commentId);
        return this.commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(String postId) {
        return this.commentRepository.getCommentsByPostId(postId);
    }

    @Override
    public List<Comment> getCommentsByUserId(String userId) {
        return this.commentRepository.getCommentsByUserId(userId);
    }

    @Override
    public List<Comment> getAllComments() {
        return this.commentRepository.findAll();
    }

    @Override
    public void deleteComment(String commentId) {
        this.commentRepository.deleteById(commentId);
    }

    @Override
    public Comment updateComment(Comment comment) {
        Comment oldComment = this.commentRepository.findById(comment.getCommentId()).orElseThrow(() -> new RuntimeException("Comment not found with id: " + comment.getCommentId()));
        return this.commentRepository.save(comment);
    }

//    @Override
//    public List<Comment> getCommentsByPostIdAndUserId(String postId, String userId) {
//        return this.commentRepository.getCommentsByPostIdAndUserId(postId, userId);
//    }

    @Override
    public Comment getComment(String commentId) {
        return this.commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));
    }

//    @Override
//    public void deleteCommentByPostIdAndUserId(String postId, String userId) {
//        this.commentRepository.deleteCommentByPostIdAndUserId(postId, userId);
//    }

    @Override
    public void deleteCommentsByPostId(String postId) {
        this.commentRepository.deleteCommentsByPostId(postId);
    }

    @Override
    public void deleteCommentsByUserId(String userId) {
        this.commentRepository.deleteCommentsByUserId(userId);
    }
}
