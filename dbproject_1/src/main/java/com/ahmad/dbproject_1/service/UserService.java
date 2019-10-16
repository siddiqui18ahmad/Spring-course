package com.ahmad.dbproject_1.service;

import com.ahmad.dbproject_1.model.User;
import rx.Observable;

import java.util.List;

public interface UserService {
    Observable<List<User>> getAllUsers();

    Observable<User> getUser(String id);

    void addUser(User user);

    void updateUser(User user, String id);

    void deleteUser(String id);
}
