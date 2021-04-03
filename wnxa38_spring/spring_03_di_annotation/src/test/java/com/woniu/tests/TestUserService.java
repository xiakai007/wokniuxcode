package com.woniu.tests;

import com.woniu.dao.UserDao;
import com.woniu.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Log4j2
public class TestUserService {
    @Test
    public void testAutowire(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) context.getBean("userService");
        userService.register();
    }
    @Test
    public void testAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //UserDao userDao=(UserDao) context.getBean("userDaoImpl");
        //userDao.add();
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.register();
    }
}
