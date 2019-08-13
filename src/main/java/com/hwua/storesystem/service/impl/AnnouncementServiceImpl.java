package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.Announcement;
import com.hwua.storesystem.mapper.AnnouncementMapper;
import com.hwua.storesystem.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Map<String,Object>> list() {
        return announcementMapper.queryAll();
    }
}
