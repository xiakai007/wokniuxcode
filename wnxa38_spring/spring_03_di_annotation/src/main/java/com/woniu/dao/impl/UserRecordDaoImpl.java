package com.woniu.dao.impl;

import com.woniu.dao.UserRecordDao;
import org.springframework.stereotype.Component;

@Component
public class UserRecordDaoImpl implements UserRecordDao {
    @Override
    public void add() {
        System.out.println("记录用户注册的信息");
    }
}
