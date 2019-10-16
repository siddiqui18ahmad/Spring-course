package com.ahmad.dbproject_1.controller.controllerimpl;

import com.ahmad.dbproject_1.controller.Controller;
import com.ahmad.dbproject_1.model.User;
import com.ahmad.dbproject_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rx.Observable;

import java.util.List;

@RestController
public class ControllerImpl implements Controller {
    @Autowired
    private UserService userservice;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Observable<List<User>> getAllUsers() {
        return userservice.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public Observable<User> getUser(@PathVariable String id) {
        return userservice.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userservice.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id) {
        userservice.updateUser(user, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userservice.deleteUser(id);

    }
}
