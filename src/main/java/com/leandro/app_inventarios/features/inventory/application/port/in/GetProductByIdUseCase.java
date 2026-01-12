package com.leandro.app_inventarios.features.inventory.application.port.in;

import com.leandro.app_inventarios.features.inventory.domain.model.Product;

import java.util.Optional;

public interface GetProductByIdUseCase {
    Product findById(Long id);
}
