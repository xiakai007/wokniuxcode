package com.woniu.bootrediss.controller;


import com.woniu.bootrediss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/sendAuthcode")
    public ModelAndView sendAuthcode(ModelAndView modelAndView,HttpServletRequest request) {
        String telephone = request.getParameter("telephone");
        System.out.println("sendAuthcode:"+telephone);
        if(telephone!=null&&telephone!=""){
            boolean flag = userService.sendAuthcode(telephone);
            if(flag){
                modelAndView.addObject("telephone",telephone);
                modelAndView.setViewName("authcode.html");
                return modelAndView;
            }else{
                return null;
            }
        }else{
            modelAndView.setViewName("authcode.html");
            return modelAndView;
        }
    }
    @GetMapping(value = "/verifyAuthcode")
    public ModelAndView verifyAuthcode(HttpServletRequest request,ModelAndView modelAndView){
        String telephone = request.getParameter("telephone");
        System.out.println("verifyAuthcode:"+telephone);
        String authcode = request.getParameter("authcode");
        System.out.println("verifyAuthcode:"+authcode);
        boolean flag = userService.isExist(telephone, authcode);
        if(flag){
            modelAndView.setViewName("suc");
            System.out.println("8888888888888");
            return modelAndView;
        }else{
            return null;
        }

    }

}
