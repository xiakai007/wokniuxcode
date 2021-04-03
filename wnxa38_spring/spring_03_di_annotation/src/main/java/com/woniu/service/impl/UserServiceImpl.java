package com.woniu.service.impl;

import com.woniu.dao.UserDao;
import com.woniu.dao.UserRecordDao;
import com.woniu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //依赖注入，先按照类型注入，如果有多个类型相同的，通过@Qualifier指定名称
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Autowired
    private UserRecordDao userRecordDao;

    @Override
    public void register() {
        userDao.add();
        userRecordDao.add();
    }
}
