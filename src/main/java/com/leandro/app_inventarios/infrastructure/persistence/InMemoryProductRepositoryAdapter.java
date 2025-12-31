package com.leandro.app_inventarios.infrastructure.persistence;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("inmemory")
public class InMemoryProductRepositoryAdapter implements ProductRepositoryPort {

    private final Map<Long, Product> storage = new HashMap<>();
    private long sequence = 1L;

    public InMemoryProductRepositoryAdapter() {
        // Datos falsos
        save(new Product(null, "Laptop", 10));
        save(new Product(null, "Mouse", 50));
        save(new Product(null, "Teclado", 30));
    }

    @Override
    public Product save(Product product) {
        Long id = product.getId();
        if (id == null) {
            id = (sequence++);
            product = new Product(id, product.getName(), product.getStock());
        }
        storage.put(id, product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(storage.values());
    }
}
