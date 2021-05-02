package com.woniu.springboot.admin.controller;

import com.woniu.springboot.admin.exception.K15Exception;
import com.woniu.springboot.admin.pojo.Role;
import com.woniu.springboot.admin.service.RoleService;
import com.woniu.springboot.admin.util.Constaint;
import com.woniu.springboot.admin.util.DataGridView;
import com.woniu.springboot.admin.util.ResultCode;
import com.woniu.springboot.admin.vo.RoleVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
@Slf4j
public class RoleController {
    @Autowired
    private RoleService roleService;
    @ApiOperation("用户分配角色：查询所有角色信息")
    @GetMapping(value = "/roleList")
    public DataGridView roleList(Integer uid){
        List<Role> roleList = roleService.selectRoleAll();
        List<Role> roleListByUid = roleService.selectRoleByUid(uid);
        List<RoleVo> roleVoList=new ArrayList<>();
        if (roleList !=null&&roleList.size()>0) {
            for (Role role : roleList) {
                boolean LAY_CHECKED=false;
                for (Role roleByUid : roleListByUid) {
                    if (roleByUid.getId() == role.getId()) {
                        LAY_CHECKED=true;
                    }
                }
                RoleVo roleVo = new RoleVo();
                roleVo.setId(role.getId());
                roleVo.setRolename(role.getRolename());
                roleVo.LAY_CHECKED=LAY_CHECKED;
                roleVoList.add(roleVo);
            }
            return new DataGridView((long)roleVoList.size(),roleVoList);
        }else {
            throw new K15Exception(ResultCode.ROLELISTNULL, Constaint.ROLELISTNULL);
        }
    }
    @ApiOperation("查询所有角色列表信息")
    @GetMapping(value = "/roleListAll")
    public DataGridView roleListAll(){
        List<Role> roleList = roleService.selectRoleAll();
        if(roleList!=null&&roleList.size()>0){
            return new DataGridView((long)roleList.size(),roleList);
        }else{
            throw new K15Exception(ResultCode.ROLELISTNULL,Constaint.ROLELISTNULL);
        }
    }
}
