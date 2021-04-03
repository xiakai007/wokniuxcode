package com.woniu.dao.impl;

import com.woniu.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 如果component没有明确指定名称，默认名称为类名且首字母小写
 * 指定，component("id名称")
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl:增加用户");
    }
}
