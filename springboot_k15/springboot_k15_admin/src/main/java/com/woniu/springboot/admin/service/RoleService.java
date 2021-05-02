package com.woniu.springboot.admin.service;




import com.woniu.springboot.admin.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Role findRoleByRolename(String rolename);
    public List<Role> selectRoleAll();
    public List<Role> selectRoleByUid(Integer uid);
    public boolean assignRight(Integer rid,Integer[] permIds);
    public Set<String> selectRolenamesByUid(Integer uid);
}
