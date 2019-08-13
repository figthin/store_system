package com.hwua.storesystem.mapper;

import com.hwua.storesystem.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

    List<Product> queryAll();
}
