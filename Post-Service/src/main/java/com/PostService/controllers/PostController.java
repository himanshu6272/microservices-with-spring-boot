package com.PostService.controllers;

import com.PostService.entities.Post;
import com.PostService.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return this.postService.savePost(post);
    }

    @PutMapping("/edit")
    public Post updatePost(@RequestBody Post post) {
        return this.postService.updatePost(post);
    }

    @DeleteMapping("/delete/{postId}")
    public void  deletePost(@PathVariable("postId") String postId) {
        this.postService.deletePost(postId);
    }

    @GetMapping("/get/{postId}")
    public Post getPost(@PathVariable("postId") String postId) {
        return this.postService.getPost(postId);
    }

    @GetMapping("/getAll")
    public List<Post> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @GetMapping("/getAll/{userId}")
    public List<Post> getPostsByUserId(@PathVariable("userId") String userId) {
        return this.postService.getPostsByUserId(userId);
    }

    @DeleteMapping("/delete/user/{userId}")
    public void deletePostsByUserId(@PathVariable("userId") String userId) {
        this.postService.deletePostsByUserId(userId);
    }

}
