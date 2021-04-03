package com.woniu.service;

import com.github.pagehelper.Page;
import com.woniu.pojo.User;
import com.woniu.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public List<User> findUserAll();
    public List<User> findUserByDid(@Param("did") Integer did);
    public User getUserByRealname(@Param("realname") String realname);
    public User login(String telephone,String password);
    public boolean addUser(User user);
    public List<User> getUserByProperty(User user);
    public Page findUserPage(UserVo userVo);
    public boolean removeUser(Integer[] ids);
    public User getUserById(Integer id);
    public boolean updateUser(User user);
}
