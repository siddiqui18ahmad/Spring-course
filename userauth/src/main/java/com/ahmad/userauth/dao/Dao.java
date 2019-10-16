package com.ahmad.userauth.dao;
import com.ahmad.userauth.model.User;
import rx.Observable;

import java.util.List;

public interface Dao {
    List<User> getAllUsers();

    String register(User user);

    String login(User user);

}
