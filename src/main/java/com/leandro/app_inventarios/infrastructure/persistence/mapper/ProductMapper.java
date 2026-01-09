package com.leandro.app_inventarios.infrastructure.persistence.mapper;

import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import com.leandro.app_inventarios.infrastructure.persistence.entity.ProductEntity;

public class ProductMapper {
    public static Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getStock()
        );
    }

    public static ProductEntity toEntity(Product domain) {
        return new ProductEntity(domain.getName(), domain.getStock());
    }
}
