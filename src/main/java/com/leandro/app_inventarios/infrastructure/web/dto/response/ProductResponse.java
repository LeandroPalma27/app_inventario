package com.leandro.app_inventarios.infrastructure.web.dto.response;

import com.leandro.app_inventarios.features.inventory.domain.model.Product;

public record ProductResponse(String name, int stock) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getName(),
                product.getStock()
        );
    }
}
