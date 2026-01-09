package com.leandro.app_inventarios.infrastructure.persistence.repository;

import com.leandro.app_inventarios.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
