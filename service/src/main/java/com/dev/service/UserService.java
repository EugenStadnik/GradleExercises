package com.dev.service;

import com.dev.dao.UserDao;
import com.dev.model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();
    public List<User> getAll() {
        return userDao.findAll();
    }
}
