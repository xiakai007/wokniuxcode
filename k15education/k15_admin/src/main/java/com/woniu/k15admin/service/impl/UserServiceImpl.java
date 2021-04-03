package com.woniu.k15admin.service.impl;


import com.woniu.k15admin.mapper.UserMapper;
import com.woniu.k15admin.pojo.User;
import com.woniu.k15admin.service.UserService;
import com.woniu.k15admin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}