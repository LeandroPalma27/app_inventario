package com.leandro.app_inventarios.features.inventory.application.port.in;

import com.leandro.app_inventarios.features.inventory.application.command.CreateProductCommand;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;

public interface CreateProductUseCase {
    Product execute(CreateProductCommand command);
}
