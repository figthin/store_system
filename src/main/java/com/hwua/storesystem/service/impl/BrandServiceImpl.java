package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.Brand;
import com.hwua.storesystem.mapper.BrandMapper;
import com.hwua.storesystem.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> list() {
        return brandMapper.queryAll();
    }
}
