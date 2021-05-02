package com.woniu.springboot.admin.service;


import com.woniu.springboot.admin.pojo.User;
import com.woniu.springboot.admin.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public List<User> selectUserByPage(UserVo userVo);
    public boolean removeUser(Integer[] ids);
    public User selectUserByRealname(String realname);
    public User login(String telephone,String password);
    public boolean assignRole(Integer uid,Integer[] rids);
    public User selectUserByTel(String telephone);
}
