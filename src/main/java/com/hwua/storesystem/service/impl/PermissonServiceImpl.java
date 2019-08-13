package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.Permission;
import com.hwua.storesystem.mapper.PermissionMapper;
import com.hwua.storesystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissonServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> listByRoleIds(List<Integer> roleIds) {
        return permissionMapper.queryByRoleIds(roleIds);
    }

    @Override
    public List<Permission> list() {
        return permissionMapper.queryAll();
    }
}
