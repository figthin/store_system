package com.hwua.storesystem.service;

import com.hwua.storesystem.entity.Role;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleService {

    List<Role> list();

    Boolean add(String roleName, String description);

    Boolean sub(Integer roleId);

    Role getByRoleId(Integer roleId);

    Boolean alter(Integer roleId, String name, String description);
}
