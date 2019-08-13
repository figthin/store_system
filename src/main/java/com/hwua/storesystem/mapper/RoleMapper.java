package com.hwua.storesystem.mapper;

import com.hwua.storesystem.entity.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> queryByManagerId(Integer managerId);

    List<Role> queryAll();

    Integer doInsert(Role role);

    Integer doDelete(Integer roleId);

    Role queryByRoleId(Integer roleId);

    Integer doUpdate(Role role);
}
