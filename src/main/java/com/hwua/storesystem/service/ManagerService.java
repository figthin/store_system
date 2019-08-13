package com.hwua.storesystem.service;


import com.hwua.storesystem.entity.Manager;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    Manager login(String name, String password);

    List<Manager> list();

    Boolean insertOrUpdate(Manager manager);

    Boolean add(Manager manager);

    Boolean sub(Integer managerId);

    Boolean alterStatus(String operate, Integer managerId);

    Manager getById(Integer managerId);
}
