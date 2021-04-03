package com.woniu.tests;

import com.woniu.bean.pojo.User;
import com.woniu.mapper.UserMapper;
import com.woniu.service.UserService;
import com.woniu.util.MyBatisUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
@Log4j2
public class TestUserAndDept {
    @Test
    public void testUserWithDept(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) context.getBean("userServiceImpl");
        List<User> userList=userService.findUserAll();
        for (User user:userList) {
            log.info(user.getRealname()+"\t"+user.getDept().getDname());
        }
    }
    @Test
    public void testUserByDid(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) context.getBean("userServiceImpl");
        List<User> userList=userService.findUserByDid(2);
        for (User user:userList) {
            log.info(user.getRealname()+"\t"+user.getDept().getDname());
        }
    }
}
