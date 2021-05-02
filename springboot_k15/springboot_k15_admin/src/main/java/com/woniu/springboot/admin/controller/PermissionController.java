package com.woniu.springboot.admin.controller;

import com.woniu.springboot.admin.exception.K15Exception;
import com.woniu.springboot.admin.pojo.Permission;
import com.woniu.springboot.admin.service.PermissionService;
import com.woniu.springboot.admin.service.RoleService;
import com.woniu.springboot.admin.util.Constaint;
import com.woniu.springboot.admin.util.R;
import com.woniu.springboot.admin.util.ResultCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @ApiOperation("权限的树状菜单")
    @GetMapping(value = "/permissionList")
    public R permissionList(){
        List<Permission> permissions = permissionService.selectPermissionAll();
        if (permissions != null&&permissions.size()>0) {
            return R.ok().data("permissions",permissions);
        }else{
            throw new K15Exception(ResultCode.PERMSISNULL, Constaint.PERMSISNULL);
        }
    }
    @ApiOperation("勾选树状菜单的复选框")
    @GetMapping(value = "/getChecked")
    public R getChecked(Integer rid){
        Integer[] permIds = permissionService.getPermissionIdsByRid(rid);
        return R.ok().data("permIds",permIds);
    }
    @ApiOperation("分配权限")
    @GetMapping(value = "/assignRight")
    public R assignRight(Integer rid,Integer[] permIds){
        boolean flag = roleService.assignRight(rid, permIds);
        if(flag){
            return R.ok().code(ResultCode.PERMASSIGNSUC).message(Constaint.PERMASSIGNSUC);
        }else{
            throw new K15Exception(ResultCode.PERMASSIGNFAIL,Constaint.PERMASSIGNFAIL);
        }
    }
}
