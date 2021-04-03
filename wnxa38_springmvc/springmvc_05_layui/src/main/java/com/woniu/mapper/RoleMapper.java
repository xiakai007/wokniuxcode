package com.woniu.mapper;

import com.woniu.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    public List<Role> selectAllRole();
    public Role selectRoleByRolename(@Param("rolename") String rolename);
    public List<Role> selectRoleByPerid(@Param("perid") Integer perid);
    public List<Role> selectRoleByUid(@Param("uid") Integer uid);
}
