package com.leandro.app_inventarios.features.inventory.application.service;

import com.leandro.app_inventarios.features.inventory.application.command.CreateProductCommand;
import com.leandro.app_inventarios.features.inventory.application.port.in.CreateProductUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.in.GetProductByIdUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.in.ListProductUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.exception.ProductNotFoundException;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import jakarta.persistence.EntityNotFoundException;

import java.time.Clock;
import java.util.List;
import java.util.Optional;

public class InventoryApplicationService implements ListProductUseCase, CreateProductUseCase, GetProductByIdUseCase {

    private final ProductRepositoryPort productRepository;
    private final Clock clock;

    public InventoryApplicationService(ProductRepositoryPort productRepository, Clock clock) {
        this.productRepository = productRepository;
        this.clock = clock;
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product execute(CreateProductCommand command) {
        Product product = Product.create(command.name(), command.stock(), clock.instant());
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
