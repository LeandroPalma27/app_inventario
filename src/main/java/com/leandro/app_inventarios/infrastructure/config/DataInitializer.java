package com.leandro.app_inventarios.infrastructure.config;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepositoryPort productRepository;
    @Autowired
    Clock clock;

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product((long) 1, "PlayStation 5 PRO", 25, clock.instant()));
    }
}
