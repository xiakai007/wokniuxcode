package com.woniu.service.impl;

import com.woniu.bean.pojo.User;
import com.woniu.mapper.UserMapper;
import com.woniu.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public List<User> findUserByDid(@Param("did")Integer did) {
        return userMapper.selectUserByDid(did);
    }

    @Override
    public User getUserByRealname(@Param("realname") String realname) {
        return userMapper.selectUserByRealname(realname);
    }
}
