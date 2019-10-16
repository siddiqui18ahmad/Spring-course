package com.example.demoali.service;


import com.example.demoali.model.User;
import com.example.demoali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


    public User getUser(String id) {

        return userRepository.findById(id).get();
    }

    public void addUser(User user) {

        userRepository.save(user);
    }

    public void updateUser(User user, String id) {

        userRepository.save(user);

    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}



