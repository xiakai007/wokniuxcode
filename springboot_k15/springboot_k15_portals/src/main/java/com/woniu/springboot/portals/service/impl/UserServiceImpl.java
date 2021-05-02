package com.woniu.springboot.portals.service.impl;

import com.woniu.springboot.portals.entity.pojo.User;
import com.woniu.springboot.portals.mapper.UserMapper;
import com.woniu.springboot.portals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String account, String password) {
        return userMapper.selectUserByAccPwd(account,password);
    }
}
