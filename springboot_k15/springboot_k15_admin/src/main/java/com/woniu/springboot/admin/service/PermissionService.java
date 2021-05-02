package com.woniu.springboot.admin.service;


import com.woniu.springboot.admin.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    public List<Permission> findPermissionByRid(Integer rid);
    public Permission findPermissionByNAME(String name);
    public List<Permission> selectPermissionByUid(Integer uid);
    public List<Permission> selectPermissionAll();

    /**
     * 通过角色id查找对应的权限id的数组集合
     * @param rid
     * @return
     */
    public Integer[] getPermissionIdsByRid(Integer rid);
    public Set<String> selectPercodesByUid(Integer uid);
}
