package com.woniu.mapper;

import com.woniu.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    public List<Permission> selectAllPermission();
    public List<Permission> selectPermissionByRid(@Param("rid") Integer rid);
    public Permission selectPermissionByNAME(@Param("name") String name);
}
