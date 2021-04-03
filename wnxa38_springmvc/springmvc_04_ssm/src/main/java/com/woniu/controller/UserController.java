package com.woniu.controller;

import com.github.pagehelper.Page;
import com.woniu.pojo.Dept;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.service.DeptService;
import com.woniu.service.RoleService;
import com.woniu.service.UserService;
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
import java.util.*;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController {
    @Autowired
    public UserService userService;
    @Autowired
    public DeptService deptService;
    @Autowired
    public RoleService roleService;
    /*@RequestMapping("/getAllUser")
    public ModelAndView getAllUser(ModelAndView modelAndView){
        List<User> userList = userService.findUserAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user");
        return modelAndView;
    }*/
    @RequestMapping("/userList")
    public ModelAndView userList(UserVo userVo,ModelAndView modelAndView){
        Page userPage = userService.findUserPage(userVo);
        List<Dept> deptList = deptService.findAllDept();
        modelAndView.addObject("userPage",userPage);
        modelAndView.addObject("deptList",deptList);
        modelAndView.addObject("userVo",userVo);
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @RequestMapping("/goRegister")
    public ModelAndView goRegister(ModelAndView modelAndView){
        List<Dept> deptList = deptService.findAllDept();
        List<Role> roleList = roleService.findAllRole();
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("deptList",deptList);
        modelAndView.setViewName("userAdd");
        return modelAndView;
    }
    @RequestMapping("/doRegister")
    public ModelAndView doRegister(User user,
                                   HttpServletRequest request,
                                   @RequestParam("avatar") MultipartFile multipartFile,
                                   ModelAndView modelAndView){
        System.out.println("telephone:"+user.getTelephone());
        System.out.println("PASSWORD:"+user.getPASSWORD());
        System.out.println("realname:"+user.getRealname());
        System.out.println("birthday:"+user.getBirthday());
        System.out.println("did:"+user.getDept().getId());
        List<Role> roleListNew=new ArrayList<>();
        if(user.getRoleList()!=null){
            for(Role role:user.getRoleList()){
                if(role.getId()!=null){
                    roleListNew.add(role);
                }
            }
        }
        user.setRoleList(roleListNew);
        System.out.println(user.getRoleList());
        user.setAvailable(1);
        String filePrefixPath = request.getServletContext().getRealPath("/static/images/");
        System.out.println("图片服务器路径："+filePrefixPath);
        String originalFilename = multipartFile.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString();
        String filePath=filePrefixPath+newFileName+fileSuffix;
        try {
            multipartFile.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setHeadimg("../static/images/"+newFileName+fileSuffix);
        boolean flag = userService.addUser(user);
        if(flag){
            modelAndView.setViewName("redirect:/user/userList");
        }
        return modelAndView;
    }
    @RequestMapping("/removeUser")
    public ModelAndView removeUser(Integer[] ids,ModelAndView modelAndView){
        /*for(Integer id:ids){
            System.out.println(id);
        }*/
        boolean flag = userService.removeUser(ids);
        if(flag){
            modelAndView.setViewName("forward:/user/userList");
        }
        return modelAndView;
    }
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(User user,ModelAndView modelAndView){
        User userUpd = userService.getUserById(user.getId());
        System.out.println("userUpd.getBirthday():"+userUpd.getBirthday());
        List<Dept> deptList = deptService.findAllDept();
        List<Role> roleList = roleService.findAllRole();
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("deptList",deptList);
        modelAndView.addObject("userUpd",userUpd);
        modelAndView.setViewName("userUpd");
        return modelAndView;
    }
    @RequestMapping("/doUpdate")
    public ModelAndView doUpdate(User user,
                                 HttpServletRequest request,
                                 @RequestParam("avatar") MultipartFile avatar,
                                 ModelAndView modelAndView){
        System.out.println("user.getTelephone():"+user.getTelephone());
        System.out.println("user.getPASSWORD():"+user.getPASSWORD());
        System.out.println("user.getRealname():"+user.getRealname());
        System.out.println("user.getBirthday():"+user.getBirthday());
        System.out.println("user.getDept().getId():"+user.getDept().getId());
        List<Role> roles=new ArrayList<>();
        if(user.getRoleList()!=null){
            for(Role role:user.getRoleList()){
                if(role.getId()!=null){
                    roles.add(role);
                }
            }
        }
        user.setRoleList(roles);
        String realPath = request.getServletContext().getRealPath("/static/images/");
        String originalFilename = avatar.getOriginalFilename();
        String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName=UUID.randomUUID().toString();
        String filePath=realPath+newFileName+fileSuffix;
        System.out.println(filePath);
        try {
            avatar.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setHeadimg("../static/images/"+newFileName+fileSuffix);
        boolean flag = userService.updateUser(user);
        System.out.println("===========");
        if(flag){
            modelAndView.setViewName("redirect:/user/userList");
        }
        return modelAndView;
    }
    //指定页面接受JSON格式数据
    @ResponseBody
    @RequestMapping("/selectUserList")
    public Page<Object> selectUserList(UserVo userVo){
        Page<Object> userPage = userService.findUserPage(userVo);
        return userPage;
    }
    @RequestMapping("/toAjaxdemo1")
    public String toAjaxdemo1(){
        return "ajaxdemo1";
    }
    //指定页面接受JSON格式数据
    @ResponseBody
    @RequestMapping("/testAjaxDemo1")
    public Map<String,Object> testAjaxDemo1(@RequestBody User user){
        System.out.println("telephone:"+user.getTelephone());
        System.out.println("password:"+user.getPASSWORD());
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("msg","ok");
        return map;
    }
}
