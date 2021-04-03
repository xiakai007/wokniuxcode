package com.woniu.service.impl;

import com.woniu.bean.pojo.Permission;
import com.woniu.mapper.PermissionMapper;
import com.woniu.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
