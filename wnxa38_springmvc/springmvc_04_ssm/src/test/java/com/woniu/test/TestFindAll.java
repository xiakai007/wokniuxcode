package com.woniu.test;

import com.woniu.pojo.Dept;
import com.woniu.pojo.Permission;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.service.DeptService;
import com.woniu.service.PermissionService;
import com.woniu.service.RoleService;
import com.woniu.service.UserService;
import com.woniu.vo.UserVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestFindAll {
    @Test
    public void testFindUserPage(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        UserVo userVo = new UserVo();
        userService.findUserPage(userVo);
    }
    @Test
    public void testGetUerByProperty(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        User userSear=new User();
        userSear.setRealname("张");
        userSear.setTelephone("12");
        Dept dept=new Dept();
        dept.setId(3);
        userSear.setDept(dept);
        List<User> users = userService.getUserByProperty(userSear);
        for(User user:users){
            System.out.println(user.getRealname()+"\t"+user.getDept().getDname());
        }
    }
    @Test
    public void testFindAllUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService)context.getBean("userServiceImpl");
        List<User> userList = userService.findUserAll();
        for (User user:userList) {
            System.out.println(user.getRealname());
        }
    }
    @Test
    public void testFindAllRole(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        RoleService roleService = (RoleService)context.getBean("roleServiceImpl");
        List<Role> roleList = roleService.findAllRole();
        for (Role role:roleList) {
            System.out.println(role.getRolename());
        }
    }
    @Test
    public void testFindAllPermission(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PermissionService permissionService = (PermissionService)context.getBean("permissionServiceImpl");
        List<Permission> permissionList = permissionService.findAllPermission();
        for (Permission permission:permissionList) {
            System.out.println(permission.getNAME());
        }
    }
    @Test
    public void testFindAllDept(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        DeptService deptService = (DeptService)context.getBean("deptServiceImpl");
        List<Dept> deptList = deptService.findAllDept();
        for (Dept dept:deptList) {
            System.out.println(dept.getDname());
        }
    }
}
