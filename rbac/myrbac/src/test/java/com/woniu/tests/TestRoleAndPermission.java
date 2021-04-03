package com.woniu.tests;

import com.woniu.bean.pojo.Permission;
import com.woniu.bean.pojo.Role;
import com.woniu.mapper.PermissionMapper;
import com.woniu.mapper.RoleMapper;
import com.woniu.service.PermissionService;
import com.woniu.service.RoleService;
import com.woniu.util.MyBatisUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Log4j2
public class TestRoleAndPermission {
    @Test
    public void testOneRoleToManyPermission(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService)context.getBean("roleServiceImpl");
        Role role = roleService.findRoleByRolename("技术专员");
        List<Permission> permissionList = role.getPermissionList();
        for(Permission permission:permissionList){
            log.info(permission.getNAME());
        }
    }
    @Test
    public void testOnePermissionToManyRole(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PermissionService permissionService = (PermissionService)context.getBean("permissionServiceImpl");
        Permission permission = permissionService.findPermissionByNAME("用户增加");
        for(Role Role:permission.getRoleList()){
            log.info(Role.getRolename());
        }
    }
}
