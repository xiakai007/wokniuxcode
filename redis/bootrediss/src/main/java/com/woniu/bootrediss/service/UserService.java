package com.woniu.bootrediss.service;

public interface UserService {
    public boolean sendAuthcode(String telephone);
    public boolean isExist(String telephone,String authcode);
}
