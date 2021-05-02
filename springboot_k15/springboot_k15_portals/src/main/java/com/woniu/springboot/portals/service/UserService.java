package com.woniu.springboot.portals.service;

import com.woniu.springboot.portals.entity.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public User login(String account,String password);
}
