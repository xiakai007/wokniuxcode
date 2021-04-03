package com.woniu.auth.service.impl;

import com.woniu.auth.mbg.mapper.UserinfoMapper;
import com.woniu.auth.mbg.model.Userinfo;
import com.woniu.auth.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService{
    @Autowired
    private UserinfoMapper userinfoMapper;
    public Userinfo login(String username,String password) {
        Userinfo userinfoLogin = userinfoMapper.selectUserinfoLogin(username,password);
        return userinfoLogin;
    }
}
