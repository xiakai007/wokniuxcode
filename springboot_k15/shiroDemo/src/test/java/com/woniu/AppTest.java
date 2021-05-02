package com.woniu;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void testShiro()
    {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("tom", "123457");
        subject.login(token);
        if(subject.isAuthenticated()){
            System.out.println("登录成功");
            if (subject.hasRole("admin")) {
                System.out.println("tom有admin的角色");
            }else{
                System.out.println("tom没有admin的角色");
            }
            if (subject.isPermitted("modify")) {
                System.out.println("tom有modify权限");
            }else{
                System.out.println("tom没有modify权限");
            }
            if(subject.isPermittedAll("modify","add","delete","update")){
                System.out.println("有");
            }else{
                System.out.println("没有");
            }
        }else{
            System.out.println("登录失败");
        }
        subject.logout();
    }
}
