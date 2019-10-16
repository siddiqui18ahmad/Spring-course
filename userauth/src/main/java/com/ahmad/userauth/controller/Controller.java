package com.ahmad.userauth.controller;

import com.ahmad.userauth.model.User;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/user")
public interface Controller {

    String register(User user);

    String login(User user);

}