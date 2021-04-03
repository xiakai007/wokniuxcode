package com.woniu.service;

import com.woniu.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAllPermission();
    public List<Permission> findPermissionByRid(@Param("rid") Integer rid);
    public Permission findPermissionByNAME(@Param("name") String name);
}
