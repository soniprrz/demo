// UserController.java
package com.geektext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Geektext.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * @param username
     * @param updatedUser
     */
    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        User user = (User) userRepository.findByUsername(username);
        if (user != null) {
            user.setName(updatedUser.getName());
            userRepository.save(user);
        }
    }
}
