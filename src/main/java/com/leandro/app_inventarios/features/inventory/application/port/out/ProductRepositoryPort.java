package com.leandro.app_inventarios.features.inventory.application.port.out;

import com.leandro.app_inventarios.features.inventory.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
