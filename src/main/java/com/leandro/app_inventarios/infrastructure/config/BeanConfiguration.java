package com.leandro.app_inventarios.infrastructure.config;

import com.leandro.app_inventarios.features.inventory.application.port.out.ProductRepositoryPort;
import com.leandro.app_inventarios.features.inventory.application.service.InventoryApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class BeanConfiguration {
    @Bean
    public Clock systemClock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public InventoryApplicationService productService(ProductRepositoryPort productRepository, Clock clock) {
        return new InventoryApplicationService(productRepository, clock);
    }
}
