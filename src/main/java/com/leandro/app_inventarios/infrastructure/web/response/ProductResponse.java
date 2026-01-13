package com.leandro.app_inventarios.infrastructure.web.response;

import com.leandro.app_inventarios.features.inventory.domain.model.Product;

public record ProductResponse(Long id, String name, int stock, String createdAt) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getStock(),
                product.getCreatedAt().toString()
        );
    }
}
