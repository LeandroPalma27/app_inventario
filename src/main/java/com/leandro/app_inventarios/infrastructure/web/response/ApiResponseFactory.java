package com.leandro.app_inventarios.infrastructure.web.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ApiResponseFactory {
    private ApiResponseFactory() {}

    public static <T> ResponseEntity<ApiResponse<T>> success(
        T data,
        String path,
        HttpStatus status
    ) {
        return ResponseEntity
            .status(status)
            .body(ApiResponse.success(
                data,
                path,
                status.value()
            ));
    }

    public static ResponseEntity<ApiResponse<Void>> success(
        String path,
        HttpStatus status
    ) {
        return ResponseEntity
            .status(status)
            .body(ApiResponse.success(
                null,
                path,
                status.value()
            ));
    }
}
