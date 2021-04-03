package com.woniu.service.impl;

import com.woniu.pojo.User;
import com.woniu.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean addUser(Integer id, String name) {
        System.out.println("addUser(Integer id, String name)");
        return false;
    }

    @Override
    public boolean addUser(User user) {
        System.out.println("addUser(User user)");
        return false;
    }
}
