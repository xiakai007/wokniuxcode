package com.woniu.service;

import com.woniu.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    public List<Role> findAllRole();
    public Role findRoleByRolename(@Param("rolename") String rolename);
    public List<Role> findRoleByPerid(@Param("perid") Integer perid);
}
