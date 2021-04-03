package com.woniu.controller;

import com.woniu.pojo.Role;
import com.woniu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    public RoleService roleService;
    /*@RequestMapping("/getAllRole")
    public ModelAndView getAllRole(ModelAndView modelAndView){
        List<Role> roleList = roleService.findAllRole();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role");
        return modelAndView;
    }*/
    @ResponseBody
    //@RequestMapping(value="/roles",method= RequestMethod.POST)，简写为@PostMapping(value="/roles")
    @PostMapping(value="/roles")
    public Map<String,Object> addRole(Role role){
        System.out.println("******addRole******");
        return null;
    }
    @ResponseBody
    @RequestMapping(value="/roles/{id}",method=RequestMethod.DELETE)
    public Map<String,Object> removeRole(@PathVariable("id") Integer id){
        System.out.println("******removeRole******");
        return null;
    }
    @ResponseBody
    @RequestMapping(value="/roles",method=RequestMethod.PUT)
    public Map<String,Object> updateRole(Role role){
        System.out.println("******updateRole******");
        return null;
    }
    @ResponseBody
    //@RequestMapping(value="/roles",method=RequestMethod.GET),简写为@GetMapping(value="/roles")
    @GetMapping(value="/roles")
    public Map<String,Object> selectRoles(){
        Map<String,Object> map=new HashMap<>();
        System.out.println("******selectRoles******");
        return map;
    }
    @ResponseBody
    @RequestMapping(value="/roles/{id}",method=RequestMethod.GET)
    public Map<String,Object> selectRoleById(@PathVariable("id")Integer id){
        System.out.println("******selectRoleById******");
        return null;
    }
}
