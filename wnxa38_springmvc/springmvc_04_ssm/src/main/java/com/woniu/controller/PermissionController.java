package com.woniu.controller;

import com.woniu.pojo.Permission;
import com.woniu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/getAllPermission")
    public ModelAndView getAllPermission(ModelAndView modelAndView){
        List<Permission> permissionList = permissionService.findAllPermission();
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.setViewName("permission");
        return modelAndView;
    }
}
