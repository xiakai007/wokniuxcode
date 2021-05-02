package com.woniu.springboot.admin.service.impl;

import com.woniu.springboot.admin.mapper.RoleMapper;
import com.woniu.springboot.admin.pojo.Role;
import com.woniu.springboot.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role findRoleByRolename(String rolename) {
        return roleMapper.selectRoleByRolename(rolename);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Role> selectRoleAll() {
        return roleMapper.selectRoleAll();
    }
    @Transactional(readOnly = true)
    @Override
    public List<Role> selectRoleByUid(Integer uid) {
        return roleMapper.selectRoleByUid(uid);
    }
    @Transactional
    @Override
    public boolean assignRight(Integer rid, Integer[] permIds) {
        boolean flag=false;
        roleMapper.deleteRoleAndPermByRid(rid);
        if(permIds!=null&&permIds.length>0){
            for (Integer perid : permIds) {
                Map<String,Integer> map=new HashMap<>();
                map.put("rid",rid);
                map.put("perid",perid);
                roleMapper.addRoleAndPerm(map);
            }
        }
        flag=true;
        return flag;
    }

    @Override
    public Set<String> selectRolenamesByUid(Integer uid) {
        return roleMapper.selectRolenamesByUid(uid);
    }
}
