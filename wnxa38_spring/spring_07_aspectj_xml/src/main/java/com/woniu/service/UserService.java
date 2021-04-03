package com.woniu.service;

import com.woniu.pojo.User;

public interface UserService {
    public boolean addUser(Integer id,String name);
    public boolean addUser(User user);
}
