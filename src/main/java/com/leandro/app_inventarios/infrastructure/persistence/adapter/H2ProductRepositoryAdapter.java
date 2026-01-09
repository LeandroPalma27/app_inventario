package com.leandro.app_inventarios.infrastructure.persistence.adapter;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import com.leandro.app_inventarios.infrastructure.persistence.entity.ProductEntity;
import com.leandro.app_inventarios.infrastructure.persistence.mapper.ProductMapper;
import com.leandro.app_inventarios.infrastructure.persistence.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@Profile("h2")
public class H2ProductRepositoryAdapter implements ProductRepositoryPort {

    private final JpaProductRepository jpaProductRepository;

    public H2ProductRepositoryAdapter(JpaProductRepository jpaRepository) {
        this.jpaProductRepository = jpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = this.jpaProductRepository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream().map(ProductMapper::toDomain).toList();
    }
}
