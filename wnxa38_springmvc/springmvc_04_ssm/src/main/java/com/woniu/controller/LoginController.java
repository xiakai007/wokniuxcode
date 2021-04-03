package com.woniu.controller;

import com.woniu.pojo.User;
import com.woniu.service.UserService;
import com.woniu.util.Constaint;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("goLogin")
    public String goLogin(){
        return "login";
    }
    @RequestMapping(value = "doLogin",method= RequestMethod.POST)
    public ModelAndView doLogin(ModelAndView modelAndView,
                                String telephone,
                                @RequestParam("pwd") String password,
                                HttpSession session){
        User loginUser = userService.login(telephone, password);
        if(loginUser!=null){
            session.setAttribute("USER_SESSION",loginUser);
            modelAndView.setViewName("index");
        }else{
            modelAndView.addObject("LOGIN_ERROR", Constaint.LOGIN_ERROR);
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
