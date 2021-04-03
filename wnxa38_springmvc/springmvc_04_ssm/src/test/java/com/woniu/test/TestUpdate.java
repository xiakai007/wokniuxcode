package com.woniu.test;

import com.woniu.pojo.Dept;
import com.woniu.pojo.User;
import com.woniu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUpdate {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        User user = new User();
        user.setId(15);
        user.setRealname("333333");
        Dept dept = new Dept();
        dept.setId(1);
        user.setDept(dept);
        //user.setBirthday(Thu Nov 05 00:00:00 CST 2020);
        userService.updateUser(user);
    }
}
