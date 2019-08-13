package com.hwua.storesystem.service;

import com.hwua.storesystem.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> listByRoleIds(List<Integer> roleIds);

    List<Permission> list();

}
