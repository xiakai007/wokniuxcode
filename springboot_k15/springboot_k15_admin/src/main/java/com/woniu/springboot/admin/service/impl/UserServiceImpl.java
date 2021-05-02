package com.woniu.springboot.admin.service.impl;


import com.woniu.springboot.admin.mapper.UserMapper;
import com.woniu.springboot.admin.pojo.User;
import com.woniu.springboot.admin.service.UserService;
import com.woniu.springboot.admin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectUserByPage(UserVo userVo) {
        return userMapper.selectUserByProperty(userVo);
    }

    @Override
    public boolean removeUser(Integer[] ids) {
        if(ids!=null&&ids.length>0){
            for(Integer id:ids){
                userMapper.removeUser(id);
            }
        }
        return true;
    }

    @Override
    public User selectUserByRealname(String realname) {
        return userMapper.selectUserByRealname(realname);
    }
    @Transactional(readOnly = true)
    @Override
    public User login(String telephone, String password) {
        User user = userMapper.selectUserByTelAndPwd(telephone, password);
        return user;
    }
    @Transactional
    @Override
    public boolean assignRole(Integer uid, Integer[] rids) {
        boolean flag=false;
        int delresult = userMapper.deleteUserAndRoleByUid(uid);
        if(delresult>0){
            for (Integer rid : rids) {
                userMapper.insertUserAndRole(uid,rid);
            }
        }
        flag=true;
        return flag;
    }

    @Override
    public User selectUserByTel(String telephone) {
        return userMapper.selectUserByTel(telephone);
    }
}
