package com.leandro.app_inventarios.infrastructure.web.dto.response;

public record ApiError(
        String code,
        String message
) {
}
