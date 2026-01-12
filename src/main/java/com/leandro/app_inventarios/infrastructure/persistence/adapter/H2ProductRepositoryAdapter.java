package com.leandro.app_inventarios.infrastructure.persistence.adapter;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import com.leandro.app_inventarios.infrastructure.persistence.entity.ProductEntity;
import com.leandro.app_inventarios.infrastructure.persistence.mapper.ProductMapper;
import com.leandro.app_inventarios.infrastructure.persistence.repository.SpringDataProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("h2")
public class H2ProductRepositoryAdapter implements ProductRepositoryPort {

    private final SpringDataProductRepository springDataProductRepository;

    public H2ProductRepositoryAdapter(SpringDataProductRepository jpaRepository) {
        this.springDataProductRepository = jpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = this.springDataProductRepository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public List<Product> findAll() {
        return springDataProductRepository.findAll().stream().map(ProductMapper::toDomain).toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return springDataProductRepository.findById(id).map(ProductMapper::toDomain);
    }
}
