package com.woniu.springboot.admin.interceptor;

import com.woniu.springboot.admin.pojo.User;
import com.woniu.springboot.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SessionInterceptor implements HandlerInterceptor{
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("*****拦截器preHandle****");
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()&&subject.isRemembered()){
            PrincipalCollection principals = subject.getPrincipals();
            //String telephone = (String)principals.getPrimaryPrincipal();
            String telephone = principals.toString();
            Session session = subject.getSession();
            if(session.getAttribute("USER_SESSION")==null){
                User user = userService.selectUserByTel(telephone);
                session.setAttribute("USER_SESSION",user);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
