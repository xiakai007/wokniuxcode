package com.woniu.springboot.admin.controller;

import com.woniu.springboot.admin.exception.K15Exception;
import com.woniu.springboot.admin.pojo.Permission;
import com.woniu.springboot.admin.pojo.User;
import com.woniu.springboot.admin.service.PermissionService;
import com.woniu.springboot.admin.service.UserService;
import com.woniu.springboot.admin.util.Constaint;
import com.woniu.springboot.admin.util.R;
import com.woniu.springboot.admin.util.ResultCode;
import com.woniu.springboot.admin.vo.NavNode;
import com.woniu.springboot.admin.vo.NavNodeBuilder;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
/*welcome to C language world*/
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @ApiOperation("用户登录功能")
    @GetMapping("/login")
    public R login(String telephone, String PASSWORD,@RequestParam(value = "rememberMe",defaultValue = "0") Integer rememberMe){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(telephone, PASSWORD);
        if (rememberMe == 1) {
            token.setRememberMe(true);
        }
        try {
            /*验证前台传来的手机号、密码是否正确*/
            subject.login(token);
            Session session = subject.getSession();
            User loginUser = userService.selectUserByTel(telephone);
            session.setAttribute("USER_SESSION",loginUser);
            return R.ok().code(ResultCode.USERLOGINSUCCESS).message(Constaint.USERLOGINSUCCESS);
        } catch (AuthenticationException e) {
            throw new K15Exception(ResultCode.USERLOGINFAILURE,Constaint.USERLOGINFAILURE);
        }
        /*User loginUser = userService.login(telephone, PASSWORD);
        if(loginUser!=null){
            session.setAttribute("USER_SESSION",loginUser);
            return R.ok().code(ResultCode.USERLOGINSUCCESS).message(Constaint.USERLOGINSUCCESS);
        }else{
            throw new K15Exception(ResultCode.USERLOGINFAILURE,Constaint.USERLOGINFAILURE);
        }*/
    }
    @ApiOperation("展示首页菜单")
    @GetMapping("/showIndexMenu")
    public List<NavNode> showIndexMenu(HttpSession session){
        User loginUser = (User)session.getAttribute("USER_SESSION");
        List<NavNode> navNodeList=new ArrayList<>();
        if(loginUser!=null){
            List<Permission> permissionList = permissionService.selectPermissionByUid(loginUser.getId());
            if(permissionList!=null){
                for(Permission permission:permissionList){
                    NavNode navNode = new NavNode();
                    navNode.setId(permission.getId());
                    navNode.setPid(permission.getPid());
                    navNode.setTitle(permission.getName());
                    navNode.setIcon(permission.getIcon());
                    navNode.setHref(permission.getHref());
                    if (permission.getOPEN() == 1) {
                        navNode.setSpread(true);
                    }else if(permission.getOPEN()==0){
                        navNode.setSpread(false);
                    }
                    navNodeList.add(navNode);
                }
            }
        }
        //topId为权限表中调度系统的id
        List<NavNode> navNodes = NavNodeBuilder.build(navNodeList, 1);
        return navNodes;
    }
}
