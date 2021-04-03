package com.woniu.controller;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/hello")
@Controller
public class HelloController {
    @RequestMapping("/exec")
    public ModelAndView execute(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Springmvc整合Thymeleaf的演示");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
}
