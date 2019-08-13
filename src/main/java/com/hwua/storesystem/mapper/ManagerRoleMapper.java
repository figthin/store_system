package com.hwua.storesystem.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ManagerRoleMapper {

    Integer doInsert(Map<String, Object> map);

}
