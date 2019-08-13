package com.hwua.storesystem.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentMapper {

    List<Map<String,Object>> queryAll();

}
