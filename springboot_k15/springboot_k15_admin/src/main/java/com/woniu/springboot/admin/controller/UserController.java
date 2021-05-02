package com.woniu.springboot.admin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.woniu.springboot.admin.exception.K15Exception;
import com.woniu.springboot.admin.pojo.User;
import com.woniu.springboot.admin.service.UserService;
import com.woniu.springboot.admin.util.Constaint;
import com.woniu.springboot.admin.util.DataGridView;
import com.woniu.springboot.admin.util.R;
import com.woniu.springboot.admin.util.ResultCode;
import com.woniu.springboot.admin.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    /*@RequestMapping("/goUserAdd")
    public ModelAndView goUserAdd(ModelAndView modelAndView){
        modelAndView.setViewName("userAdd");//去页面userAdd.html
        return modelAndView;
    }*/
    @ApiOperation(value="用户分页功能")
    @GetMapping("userList")
    public DataGridView userList(UserVo userVo){
        Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
        List<User> userList = userService.selectUserByPage(userVo);
        //userList=null;//测试空指针异常
        if(userList!=null&&userList.size()>0){
            return new DataGridView(page.getTotal(),userList);
        }else{
            throw new K15Exception(ResultCode.USERLISTNULL, Constaint.USERISNULL);
        }
    }
    /**
     * 软删，只改变available的状态
     */
    @ApiOperation(value="按用户id批量删除")
    @PostMapping(value="removeUser")
    public R removeUser(@ApiParam(required = true,name="ids",value="用户编号集合") Integer[] ids){
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
    @ApiOperation(value="重新分配角色")
    @GetMapping(value="assignRole")
    public R assignRole(Integer uid,Integer[] rids){
        for (Integer rid : rids) {
            log.info("rid:"+rid);
        }
        log.info("uid:"+uid);
        boolean flag = userService.assignRole(uid, rids);
        if(flag){
            return R.ok().code(ResultCode.ROLEASSIGNSUC).message(Constaint.ROLEASSIGNSUC);
        }else{
            throw new K15Exception(ResultCode.ROLEASSIGNFAIL,Constaint.ROLEASSIGNFAIL);
        }
    }
    @ApiOperation(value="安全退出")
    @GetMapping(value = "/safeExit")
    public R safeExit(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok().code(ResultCode.USERSAFEEXIT).message(Constaint.USERSAFEEXIT);
    }
}
