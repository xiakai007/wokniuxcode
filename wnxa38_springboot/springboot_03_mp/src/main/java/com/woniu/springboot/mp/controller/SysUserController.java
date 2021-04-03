package com.woniu.springboot.mp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.woniu.springboot.mp.exception.K15Exception;
import com.woniu.springboot.mp.pojo.SysUser;
import com.woniu.springboot.mp.service.SysUserService;
import com.woniu.springboot.mp.util.Constaint;
import com.woniu.springboot.mp.util.DataGridView;
import com.woniu.springboot.mp.util.ResultCode;
import com.woniu.springboot.mp.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiakai
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/mp/sys-user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @GetMapping(value="/userList")
    public DataGridView userList(UserVo userVo){
        Page<SysUser> page = new Page<>(userVo.getPage(),userVo.getLimit());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if(!StringUtil.isEmpty(userVo.getRealname())){
            queryWrapper.like("realname",userVo.getRealname());
        }
        sysUserService.page(page,queryWrapper);//分页操作
        List<SysUser> records = page.getRecords();
        if(records!=null&&records.size()>0){
            return new DataGridView(page.getTotal(),records);
        }else {
            throw new K15Exception(ResultCode.USERLISTNULL, Constaint.USERISNULL);
        }
    }
}

