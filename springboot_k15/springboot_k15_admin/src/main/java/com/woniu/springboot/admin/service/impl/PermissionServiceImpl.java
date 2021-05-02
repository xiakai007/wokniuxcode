package com.woniu.springboot.admin.service.impl;


import com.woniu.springboot.admin.mapper.PermissionMapper;
import com.woniu.springboot.admin.pojo.Permission;
import com.woniu.springboot.admin.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findPermissionByRid(@Param("rid")Integer rid) {
        return permissionMapper.selectPermissionByRid(rid);
    }

    @Override
    public Permission findPermissionByNAME(@Param("name")String name) {
        return permissionMapper.selectPermissionByNAME(name);
    }

    @Override
    public List<Permission> selectPermissionByUid(Integer uid) {
        return permissionMapper.selectPermissionByUid(uid);
    }

    @Override
    public List<Permission> selectPermissionAll() {
        return permissionMapper.selectPermissionAll();
    }

    @Override
    public Integer[] getPermissionIdsByRid(Integer rid) {
        List<Permission> permissions = permissionMapper.selectPermissionByRid(rid);
        Integer[] permissionIds=null;
        if (permissions != null&&permissions.size()>0) {
            permissionIds=new Integer[permissions.size()];
            for(int i=0;i<permissions.size();i++){
                permissionIds[i]=permissions.get(i).getId();
            }
        }
        return permissionIds;
    }

    @Override
    public Set<String> selectPercodesByUid(Integer uid) {
        return permissionMapper.selectPercodesByUid(uid);
    }
}
