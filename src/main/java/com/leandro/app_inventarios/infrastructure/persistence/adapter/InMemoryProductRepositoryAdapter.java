package com.leandro.app_inventarios.infrastructure.persistence.adapter;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.Clock;
import java.util.*;

@Repository
@Profile("inmemory")
public class InMemoryProductRepositoryAdapter implements ProductRepositoryPort {

    private final Map<Long, Product> storage = new HashMap<>();
    private long sequence = 1L;
    @Autowired
    Clock clock;

    public InMemoryProductRepositoryAdapter() {
        // Datos falsos
        save(new Product((long) 1, "Laptop", 10, clock.instant()));
        save(new Product((long) 2, "Mouse", 50, clock.instant()));
        save(new Product((long) 3, "Teclado", 30, clock.instant()));
    }

    @Override
    public Product save(Product product) {
        Long id = product.getId();
        if (id == null) {
            id = (sequence++);
            product = Product.create(product.getName(), product.getStock(), product.getCreatedAt());
        }
        storage.put(id, product);
        return product;
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
