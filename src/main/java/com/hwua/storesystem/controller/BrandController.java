package com.hwua.storesystem.controller;

import com.hwua.storesystem.entity.Brand;
import com.hwua.storesystem.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/product-brand")
    public String productBrand(Model model){
        List<Brand> brands = brandService.list();
        model.addAttribute("brands",brands);
        return "product-brand";
    }

}
