package com.leandro.app_inventarios.infrastructure.persistence.adapter;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("jpa")
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

}
