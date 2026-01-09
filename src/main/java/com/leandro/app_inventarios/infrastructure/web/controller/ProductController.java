package com.leandro.app_inventarios.infrastructure.web.controller;

import com.leandro.app_inventarios.features.inventory.application.service.ProductService;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }
}
