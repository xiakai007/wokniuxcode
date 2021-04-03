package com.woniu.auth.service;

import com.woniu.auth.mbg.model.Userinfo;

public interface UserinfoService {
    Userinfo login(String username,String password);
}
