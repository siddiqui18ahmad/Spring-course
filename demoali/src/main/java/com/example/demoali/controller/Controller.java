package com.example.demoali.controller;


import com.example.demoali.model.User;
import com.example.demoali.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    private UserService userservice;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userservice.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public User getTopic(@PathVariable String id) {
        return userservice.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addTopic(@RequestBody User user) {
        userservice.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateTopic(@RequestBody User user, @PathVariable String id) {
        userservice.updateUser(user, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteTopic(@PathVariable String id) {
        userservice.deleteUser(id);
    }
}

