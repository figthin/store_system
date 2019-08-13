package com.hwua.storesystem.controller;

import com.hwua.storesystem.entity.Product;
import com.hwua.storesystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product-list")
    public String productList(Model model){
        List<Product> products = productService.list();
        model.addAttribute("products",products);
        return "product-list";
    }

}
