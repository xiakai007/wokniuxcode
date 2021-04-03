package com.woniu.service;

import com.woniu.pojo.User;
import com.woniu.vo.UserVo;

import java.util.List;

public interface UserService {
    public List<User> selectUserByPage(UserVo userVo);
    public boolean removeUser(Integer[] ids);
    public boolean addUser(User user);
}
