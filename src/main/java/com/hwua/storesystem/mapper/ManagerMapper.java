package com.hwua.storesystem.mapper;

import com.hwua.storesystem.entity.Manager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper {

    List<Manager> queryAll();

    Manager queryById(Integer managerId);

    Manager queryByName(String name);

    Integer doInsert(Manager manager);

    Integer doUpdate(Manager manager);

    Integer doDelete(Integer managerId);

    Integer doUpdateStart(Integer managerId);

    Integer doUpdateStop(Integer managerId);

    List<Manager> queryByRoleId(Integer roleId);
}
