package com.woniu.tests;

import com.woniu.bean.pojo.Role;
import com.woniu.bean.pojo.User;
import com.woniu.service.RoleService;
import com.woniu.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Log4j2
public class TestUserAndRole {
    @Test
    public void testOneRoleToManyUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
        Role role = roleService.findRoleByRolename("管理员");
        for (User user : role.getUserList()) {
            log.info(user.getRealname());
        }
    }

    @Test
    public void testOneUserToManyRole() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        User user = userService.getUserByRealname("tom");
        for (Role role : user.getRoleList()) {
            log.info(role.getRolename());
        }
    }
}
