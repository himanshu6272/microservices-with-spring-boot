package com.UserService.controllers;

import com.UserService.entities.User;
import com.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        return this.userService.getUser(userId);
    }

    @PostMapping("/create")
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @PutMapping("/edit")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        this.userService.deleteUser(userId);
    }

}
