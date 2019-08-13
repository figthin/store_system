package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.Product;
import com.hwua.storesystem.mapper.ProductMapper;
import com.hwua.storesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> list() {
        return productMapper.queryAll();
    }
}
