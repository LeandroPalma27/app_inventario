package com.leandro.app_inventarios.features.inventory.application.port.out;

import com.leandro.app_inventarios.features.inventory.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
}
