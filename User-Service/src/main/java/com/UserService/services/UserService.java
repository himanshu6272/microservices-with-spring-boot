package com.UserService.services;

import com.UserService.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(String userId);
    void deleteUser(String userId);
    User updateUser(User user);

}
