package com.CommentService.controllers;

import com.CommentService.entities.Comment;
import com.CommentService.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment) {
        return this.commentService.saveComment(comment);
    }
    @PutMapping("/edit")
    public Comment editComment(@RequestBody Comment comment) {
        return this.commentService.updateComment(comment);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        this.commentService.deleteComment(commentId);
    }

    @GetMapping("/get/{commentId}")
    public Comment getComment(@PathVariable String commentId) {
        return this.commentService.getComment(commentId);
    }

    @GetMapping("/getAll/post/{postId}")
    public List<Comment> getCommentsByPostId(@PathVariable String postId) {
        return this.commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/getAll/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable String userId) {
        return this.commentService.getCommentsByUserId(userId);
    }

    @GetMapping("/getAll")
    public List<Comment> getAllComments() {
        return this.commentService.getAllComments();
    }

//    @GetMapping("/getAll/post/user/{postId}/{userId}")
//    public List<Comment> getCommentsByPostIdAndUserId(@PathVariable("postId") String postId, @PathVariable("userId") String userId) {
//        return this.commentService.getCommentsByPostIdAndUserId(postId, userId);
//    }

    @DeleteMapping("/delete/post/{postId}")
    public void deleteCommentsByPostId(@PathVariable("postId") String postId) {
        this.commentService.deleteCommentsByPostId(postId);
    }

    @DeleteMapping("/delete/user/{userId}")
    public void deleteCommentByUserId(@PathVariable("userId") String userId) {
        this.commentService.deleteCommentsByUserId(userId);
    }

//    @DeleteMapping("/delete/post/{postId}/{userId}")
//    public void deleteCommentByPostIdAndUserId(@PathVariable("postId") String postId, @PathVariable("userId") String userId) {
//        this.commentService.deleteCommentByPostIdAndUserId(postId, userId);
//    }

}
