package com.woniu.springboot.admin.mapper;

import com.woniu.springboot.admin.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RoleMapper {
    public Role selectRoleByRolename(@Param("rolename") String rolename);
    public List<Role> selectRoleByUid(@Param("uid")Integer uid);
    public List<Role> selectRoleByPerid(@Param("perid") Integer perid);
    public List<Role> selectRoleAll();
    public int deleteRoleAndPermByRid(@Param("rid")Integer rid);
    public int addRoleAndPerm(Map<String,Integer> map);
    public Set<String> selectRolenamesByUid(@Param("uid")Integer uid);
}
