package com.woniu.springboot.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 跳转控制器
 */
@Controller
public class ForwardController {
    //login.js中window.location.href="goIndex";
    @RequestMapping("/goIndex")
    public ModelAndView goIndex(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/goUserList")
    public ModelAndView goUserList(ModelAndView modelAndView){
        modelAndView.setViewName("userList");
        return modelAndView;
    }
    @RequestMapping("/goUserRoles")
    public ModelAndView goUserRoles(ModelAndView modelAndView){
        modelAndView.setViewName("userRoles");
        return modelAndView;
    }
    @RequestMapping("/goRoleList")
    public ModelAndView goRoleList(ModelAndView modelAndView){
        modelAndView.setViewName("roleList");
        return modelAndView;
    }
    @RequestMapping("/goRoleRight")
    public ModelAndView goRoleRight(ModelAndView modelAndView){
        modelAndView.setViewName("roleRight");
        return modelAndView;
    }
}
