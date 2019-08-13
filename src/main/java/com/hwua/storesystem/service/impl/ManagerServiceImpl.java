package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.Manager;
import com.hwua.storesystem.exception.HelloException;
import com.hwua.storesystem.mapper.ManagerMapper;
import com.hwua.storesystem.service.ManagerService;
import com.hwua.storesystem.util.ExceptionCode;
import com.hwua.storesystem.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    private Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Override
    public Manager login(String name, String password) {
        Manager manager = managerMapper.queryByName(name);
        if (manager == null){
            throw new HelloException(ExceptionCode.USERNAME_NOT_EXISTS);
        }else {
            String password1 = manager.getPassword();
            String md5 = MD5Util.getMd5(name.concat(password));
            if (!md5.equals(password1)){
                throw new HelloException(ExceptionCode.INVALID__PASSWORD);
            }
        }
        manager.setPassword(null);
        return manager;
    }

    @Override
    public List<Manager> list() {
        return managerMapper.queryAll();
    }

    @Override
    public Boolean insertOrUpdate(Manager manager) {
        if (managerMapper.queryByName(manager.getName()) != null){
            return false;
        }
        Integer result;
        if (manager.getManagerId() != null){
            String md5 = MD5Util.getMd5(manager.getName().concat(manager.getPassword()));
            manager.setPassword(md5);
            result = managerMapper.doUpdate(manager);
        }else {
            result = managerMapper.doInsert(manager);
        }
        return result == 1;
    }

    @Override
    public Boolean add(Manager manager) {
        String md5 = MD5Util.getMd5(manager.getName().concat(manager.getPassword()));
        manager.setPassword(md5);
        return managerMapper.doInsert(manager) == 1;
    }

    @Override
    public Boolean sub(Integer managerId) {
        return managerMapper.doDelete(managerId) == 1;
    }

    @Override
    public Boolean alterStatus(String operate, Integer managerId) {
        Integer result;
        if ("启用".equals(operate)){
            result = managerMapper.doUpdateStart(managerId);
        }else {
            result = managerMapper.doUpdateStop(managerId);
        }
        return result == 1;
    }

    @Override
    public Manager getById(Integer managerId) {
        Manager manager = managerMapper.queryById(managerId);
        manager.setPassword(null);
        return manager;
    }
}
