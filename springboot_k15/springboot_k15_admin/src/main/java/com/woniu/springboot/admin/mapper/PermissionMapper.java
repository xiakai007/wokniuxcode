package com.woniu.springboot.admin.mapper;


import com.woniu.springboot.admin.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionMapper {
    public List<Permission> selectPermissionByRid(@Param("rid") Integer rid);
    public Permission selectPermissionByNAME(@Param("name") String name);
    public List<Permission> selectPermissionByUid(@Param("uid") Integer uid);
    public List<Permission> selectPermissionAll();
    public Set<String> selectPercodesByUid(@Param("uid") Integer uid);
}
