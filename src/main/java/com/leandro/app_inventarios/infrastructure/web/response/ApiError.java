package com.leandro.app_inventarios.infrastructure.web.response;

public record ApiError(
        String code,
        String message
) {
}
