package com.ahmad.dbproject_1.controller;

import com.ahmad.dbproject_1.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import rx.Observable;

import java.util.List;

@RequestMapping("/user")
public interface Controller {
    Observable<List<User>> getAllUsers();

    Observable<User> getUser(String id);

    void addUser(User user);

    void updateUser(User user, String id);

    void deleteUser(String id);
}
