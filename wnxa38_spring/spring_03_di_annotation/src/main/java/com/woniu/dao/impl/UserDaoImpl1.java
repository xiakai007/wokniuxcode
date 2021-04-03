package com.woniu.dao.impl;

import com.woniu.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl1 implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl2:增加用户2222");
    }
}
