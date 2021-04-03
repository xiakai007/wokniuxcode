package com.woniu.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.exception.K15Exception;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.service.RoleService;
import com.woniu.service.UserService;
import com.woniu.util.Constaint;
import com.woniu.util.DataGridView;
import com.woniu.util.R;
import com.woniu.util.ResultCode;
import com.woniu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("/goUserList")
    public String goUserList(){
        return "userList";
    }
    @RequestMapping("/goUserAdd")
    public ModelAndView goUserAdd(ModelAndView modelAndView){
        List<Role> roleList = roleService.findAllRole();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("userAdd");//去页面userAdd.html
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("userList")
    public DataGridView userList(UserVo userVo){
        Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
        List<User> userList = userService.selectUserByPage(userVo);
        //userList=null;
        if(userList!=null&&userList.size()>0){
            return new DataGridView(page.getTotal(),userList);
        }else{
            throw new K15Exception(ResultCode.USERLISTNULL, Constaint.USERISNULL);
        }
    }
    @ResponseBody
    @RequestMapping(value="removeUser")
    public R removeUser(Integer[] ids){
        /*for(Integer id:ids){
            System.out.println(id);
        }*/
        //boolean flag=false;
        boolean flag = userService.removeUser(ids);
        if(flag){
            return R.ok().code(ResultCode.USERREMOVESUCCESS);
        }else{
            throw new K15Exception(ResultCode.USERREMOVEFAIL,Constaint.USERREMOVEFAIL);
        }
    }
    @RequestMapping("/doAddUser")
    @ResponseBody
    public ModelAndView doAddUser(User user,
                                  HttpServletRequest request,
                                  MultipartFile headimg,
                                  ModelAndView modelAndView){
        System.out.println("realname:"+user.getRealname());
        System.out.println("birthday:"+user.getBirthday());
        List<Role> roleListSelected=new ArrayList<>();
        if(roleListSelected!=null){
            for(Role role:user.getRoleList()){
                if(role.getId()!=null){
                    roleListSelected.add(role);
                }
            }
        }
        System.out.println("7777777777");
        user.setRoleList(roleListSelected);
        System.out.println("888888888");
        String realPath = request.getServletContext().getRealPath("/static/images/");
        System.out.println("qqqqqqqq");
        System.out.println(headimg);
        String fileName = headimg.getOriginalFilename();
        System.out.println(fileName);
        System.out.println("wwwwwwwwww");
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("eeeeeeeeeeeee");
        String fileNewName = UUID.randomUUID().toString();
        System.out.println("rrrrrrrr");
        String filePath=realPath+fileNewName+fileSuffix;
        System.out.println("ttttttttt");
        try {
            System.out.println("oooooooo");
            headimg.transferTo(new File(filePath));
            System.out.println("yyyyyyyyyyyyyyyyyy");
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setHeadimg("../static/images/"+fileNewName+fileSuffix);
        System.out.println("111111111");
        boolean flag = userService.addUser(user);
        System.out.println("222222222");
        if(flag){
            System.out.println("33333333333");
            modelAndView.setViewName("redirect:/user/goUserList");
            System.out.println("444444444");
        }
        return modelAndView;
    }
}
