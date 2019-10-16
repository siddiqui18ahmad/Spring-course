package com.ahmad.dbproject_1.service.serviceimpl;

import com.ahmad.dbproject_1.dao.daoimpl.DaoImpl;
import com.ahmad.dbproject_1.model.User;
import com.ahmad.dbproject_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public DaoImpl dao;

    public Observable<List<User>> getAllUsers() {
        return dao.getAllUsers();
    }

    public Observable<User> getUser(String id) {
        return dao.getUser(id);
    }

    public void addUser(User user) {
        dao.addUser(user);
    }

    public void updateUser(User user, String id) {
        dao.updateUser(user, id);
    }

    public void deleteUser(String id) {
       dao.deleteUser(id);
    }
}
