package com.ahmad.userauth.controller.controllerImpl;

import com.ahmad.userauth.controller.Controller;
import com.ahmad.userauth.model.User;
import com.ahmad.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rx.Observable;

import java.util.List;

@RestController
public class ControllerImpl implements Controller {
    @Autowired
    private UserService userservice;

    @RequestMapping(method = RequestMethod.POST, value = "/users/register")
    public String register(@RequestBody User user) {
        return userservice.register(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String login(@RequestBody User user) {
        return userservice.login(user);
    }

}
