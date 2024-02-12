package com.UserService.services.impl;

import com.UserService.entities.Post;
import com.UserService.entities.User;
import com.UserService.repositories.UserRepository;
import com.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String userId = "user-" + UUID.randomUUID();
        user.setUserId(userId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        for (User user : users) {
            List<Post> posts = this.restTemplate.getForObject("http://POST-SERVICE/post/getAll/" + user.getUserId(), ArrayList.class);
            user.setPosts(posts);
        }
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        List<Post> posts = this.restTemplate.getForObject("http://POST-SERVICE/post/getAll/" + userId, ArrayList.class);
        user.setPosts(posts);
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        this.restTemplate.delete("http://POST-SERVICE/post/delete/user/" + userId);
        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) {
        User oldUser = this.userRepository.findById(user.getUserId()).orElseThrow(() -> new RuntimeException("User not found with id: " + user.getUserId()));
        return this.userRepository.save(user);
    }
}
