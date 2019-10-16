package com.ahmad.userauth.service;
import com.ahmad.userauth.model.User;
import rx.Observable;

import java.util.List;

public interface UserService {

    String register(User user);

    String login(User user);

}
