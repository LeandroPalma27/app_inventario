package com.leandro.app_inventarios.features.inventory.domain.exception;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException(Long id) {
        super("Producto con id " + id + " no encontrado xd.");
    }
}
