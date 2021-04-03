package com.woniu.autha.service.impl;

import com.woniu.autha.mbg.mapper.UserinfoMapper;
import com.woniu.autha.mbg.model.Userinfo;
import com.woniu.autha.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements UserinfoService{
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Override
    public Userinfo login(Userinfo userinfo) {
        Userinfo userinfoLogin = userinfoMapper.selectUserinfoLogin(userinfo.getUsername(), userinfo.getPassword());
        return userinfoLogin;
    }
}
