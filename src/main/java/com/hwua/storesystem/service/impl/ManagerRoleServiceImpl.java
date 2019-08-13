package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.mapper.ManagerRoleMapper;
import com.hwua.storesystem.service.ManagerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("managerRoleService")
public class ManagerRoleServiceImpl implements ManagerRoleService {

    @Autowired
    private ManagerRoleMapper managerRoleMapper;

    @Override
    public Boolean add(Integer managerId, Integer roleId) {
        Map<String,Object> map = new HashMap<>();
        map.put("managerId",managerId);
        map.put("roleId",roleId);
        return managerRoleMapper.doInsert(map) == 1;
    }
}
