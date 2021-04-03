package com.woniu.service.impl;

import com.woniu.mapper.RoleMapper;
import com.woniu.pojo.Role;
import com.woniu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role findRoleByRolename(String rolename) {
        return roleMapper.selectRoleByRolename(rolename);
    }

    @Override
    public List<Role> findRoleByPerid(Integer perid) {
        return roleMapper.selectRoleByPerid(perid);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.selectAllRole();
    }
}
