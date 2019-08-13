package com.hwua.storesystem.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AnnouncementMapper {

    List<Map<String,Object>> queryAll();

}
