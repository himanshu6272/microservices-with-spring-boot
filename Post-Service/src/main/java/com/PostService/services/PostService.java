package com.PostService.services;

import com.PostService.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post savePost(Post post);
    List<Post> getAllPosts();
    Post getPost(String postId);
    void deletePost(String postId);
    Post updatePost(Post post);
    List<Post> getPostsByUserId(String userId);
    void deletePostsByUserId(String userId);

}
