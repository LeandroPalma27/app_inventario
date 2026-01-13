package com.leandro.app_inventarios.features.inventory.domain.exception;

public class NotFoundException extends DomainException {
    public NotFoundException(String code, String message) {
        super(code, message);
    }
}
