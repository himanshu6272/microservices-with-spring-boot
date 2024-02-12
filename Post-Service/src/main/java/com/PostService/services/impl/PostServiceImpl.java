package com.PostService.services.impl;

import com.PostService.entities.Comment;
import com.PostService.entities.Post;
import com.PostService.repositories.PostRepository;
import com.PostService.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Post savePost(Post post) {
        String postId = "post-" + UUID.randomUUID();
        post.setPostId(postId);
        return this.postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        for (Post post : posts) {
            List<Comment> comments = this.restTemplate.getForObject("http://COMMENT-SERVICE/comment/getAll/post/" + post.getPostId(), ArrayList.class);
            post.setComments(comments);
        }
        return posts;
    }

    @Override
    public Post getPost(String postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        List< Comment> comments = this.restTemplate.getForObject("http://COMMENT-SERVICE/comment/getAll/post/" + post.getPostId(), ArrayList.class);
        post.setComments(comments);
        return post;
    }

    @Override
    public void deletePost(String postId) {
        this.restTemplate.delete("http://COMMENT-SERVICE/comment/delete/post/" + postId);
        this.postRepository.deleteById(postId);
    }

    @Override
    public Post updatePost(Post post) {
        Post postToUpdate = this.postRepository.findById(post.getPostId()).orElseThrow(() -> new RuntimeException("Post not found with id: " + post.getPostId()));
        return this.postRepository.save(post);
    }

    @Override
    public List<Post> getPostsByUserId(String userId) {
        List<Post> posts = this.postRepository.getPostsByUserId(userId);
        for (Post post : posts) {
            List<Comment> comments = this.restTemplate.getForObject("http://COMMENT-SERVICE/comment/getAll/post/" + post.getPostId(), ArrayList.class);
            post.setComments(comments);
        }
        return posts;
    }

    @Override
    public void deletePostsByUserId(String userId) {
        List<Post> posts = this.postRepository.getPostsByUserId(userId);
        for (Post post : posts) {
            this.restTemplate.delete("http://COMMENT-SERVICE/comment/delete/post/" + post.getPostId());
        }
        this.postRepository.deletePostsByUserId(userId);
    }
}
