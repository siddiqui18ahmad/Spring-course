package com.ahmad.userauth.service.serviceImpl;
import com.ahmad.userauth.dao.daoImpl.DaoImpl;
import com.ahmad.userauth.model.User;
import com.ahmad.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public DaoImpl dao;

    public String register(User user) {
        return dao.register(user);
    }

    public String login(User user) {
        return dao.login(user);
    }

}
