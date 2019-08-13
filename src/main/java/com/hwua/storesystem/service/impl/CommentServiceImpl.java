package com.hwua.storesystem.service.impl;


import com.hwua.storesystem.mapper.CommentMapper;
import com.hwua.storesystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Map<String, Object>> list() {
        return commentMapper.queryAll();
    }
}
