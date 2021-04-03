package com.woniu.mapper;

import com.woniu.bean.pojo.Permission;
import com.woniu.bean.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    public Role selectRoleByRolename(@Param("rolename") String rolename);
    public List<Role> selectRoleByPerid(@Param("perid") Integer perid);
    public List<Role> selectRoleByUid(@Param("uid") Integer uid);
}
