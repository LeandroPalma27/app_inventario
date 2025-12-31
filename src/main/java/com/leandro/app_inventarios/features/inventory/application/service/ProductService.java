package com.leandro.app_inventarios.features.inventory.application.service;

import com.leandro.app_inventarios.features.inventory.application.port.in.ListProductsUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ListProductsUseCase {

    @Autowired
    ProductRepositoryPort productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }
}
