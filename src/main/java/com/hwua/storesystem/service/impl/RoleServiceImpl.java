package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.Role;
import com.hwua.storesystem.mapper.RoleMapper;
import com.hwua.storesystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> list() {
        return roleMapper.queryAll();
    }

    @Override
    public Boolean add(String roleName, String description) {
        Role role = new Role();
        role.setName(roleName);
        role.setDescription(description);
        return roleMapper.doInsert(role) == 1;
    }

    @Override
    public Boolean sub(Integer roleId) {
        return roleMapper.doDelete(roleId) == 1;
    }

    @Override
    public Role getByRoleId(Integer roleId) {
        return roleMapper.queryByRoleId(roleId);
    }

    @Override
    public Boolean alter(Integer roleId, String name, String description) {
        Role role = new Role();
        role.setRoleId(roleId);
        role.setName(name);
        role.setDescription(description);
        return roleMapper.doUpdate(role) == 1;
    }
}
