package com.hwua.storesystem.mapper;

import com.hwua.storesystem.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    List<Permission> queryAll();

    List<Permission> queryByRoleIds(List<Integer> roleIds);

    List<Permission> queryByPermissionId(Integer permissionId);

    List<Permission> queryByParentId(Integer parentId);
}
