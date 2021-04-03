package com.woniu.service;

import com.woniu.bean.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public List<User> findUserAll();
    public List<User> findUserByDid(@Param("did") Integer did);
    public User getUserByRealname(@Param("realname") String realname);
}
