package com.leandro.app_inventarios.infrastructure.web.dto.request;

import com.leandro.app_inventarios.features.inventory.application.command.CreateProductCommand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
        @NotBlank(message = "El nombre de producto no puede estar vacio.")
        String name,

        @NotBlank(message = "El stock no puede estar vacio.")
        @Min(value = 0, message = "El stock minimo debe ser 0.")
        Integer stock
) {
    public CreateProductCommand toCommand() {
        return new CreateProductCommand(name, stock);
    }
}
