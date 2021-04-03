package com.woniu.k15admin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.k15admin.exception.K15Exception;
import com.woniu.k15admin.pojo.User;
import com.woniu.k15admin.service.UserService;
import com.woniu.k15admin.util.Constaint;
import com.woniu.k15admin.util.DataGridView;
import com.woniu.k15admin.util.R;
import com.woniu.k15admin.util.ResultCode;
import com.woniu.k15admin.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/goUserList")
    public String goUserList(){
        return "userList";
    }
    @RequestMapping("/goUserAdd")
    public ModelAndView goUserAdd(ModelAndView modelAndView){
        modelAndView.setViewName("userAdd");//去页面userAdd.html
        return modelAndView;
    }
    @ApiOperation(value="用户分页功能")
    @ResponseBody
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
    @ApiOperation(value="按用户id批量删除")
    @ResponseBody
    @GetMapping(value="removeUser")//软删，改变available的状态
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
}
