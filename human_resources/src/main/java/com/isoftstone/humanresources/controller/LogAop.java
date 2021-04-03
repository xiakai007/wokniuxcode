package com.isoftstone.humanresources.controller;

import com.isoftstone.humanresources.domain.SysLog;
import com.isoftstone.humanresources.domain.User;
import com.isoftstone.humanresources.service.SystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private SystemLogService systemLogService;

  @After("execution(* com.isoftstone.humanresources.controller.*.*(..)) && !execution(* com.isoftstone.humanresources.controller.EmployeeController.queryLog(..))")
  public void doAfter(JoinPoint jp) throws Exception {
      SysLog sysLog = new SysLog();
        //获取请求的类名
        String className = jp.getTarget().getClass().getName();
        sysLog.setOperationModule(className);
        //获取请求的方法名
      //从切面织入点处通过反射机制获取织入点处的方法
      MethodSignature signature = (MethodSignature) jp.getSignature();
      //获取切入点所在的方法
      Method method = signature.getMethod();
        String methodName = method.getName();
        sysLog.setOperationType(className + "." + methodName);

        //时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = format.format(new Date());
        sysLog.setChangeTime(updateTime);
        //获取用户名
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();        //读取session中的用户
        User user = (User) session.getAttribute("session_user");
        if(user==null){
            return;
        }
        sysLog.setLoginName(user.getUsername());
        //获取请求的ip
        String ip = request.getRemoteAddr();
        sysLog.setOperationIP(ip);
        //获取用户的操作人
        sysLog.setEmployeeID(user.getEmployeeID()+"");
        //调用service保存SysLog实体类到数据库
        try {
            systemLogService.add(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
