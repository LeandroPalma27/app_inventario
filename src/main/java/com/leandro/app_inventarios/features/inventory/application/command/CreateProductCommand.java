package com.leandro.app_inventarios.features.inventory.application.command;

public record CreateProductCommand(
        String name,
        int stock
) {
}
