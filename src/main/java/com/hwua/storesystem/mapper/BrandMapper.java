package com.hwua.storesystem.mapper;

import com.hwua.storesystem.entity.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {

    List<Brand> queryAll();

}
