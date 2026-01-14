package com.leandro.app_inventarios.infrastructure.web.response;

import com.leandro.app_inventarios.infrastructure.web.resolver.RequestPathResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ApiResponseFactory {
    private ApiResponseFactory() {
    }

    public static <T> ResponseEntity<ApiResponse<T>> buildSuccess(
            T data,
            HttpStatus status
    ) {
        String path = RequestPathResolver.currentPath();
        return ResponseEntity
                .status(status)
                .body(ApiResponse.success(
                        status.is2xxSuccessful(),
                        data,
                        path,
                        status.value()
                ));
    }

    public static ResponseEntity<ApiResponse<Void>> buildError(
            String path,
            HttpStatus status,
            String code,
            String message
    ) {
        ApiError error = new ApiError(code, message);
        return ResponseEntity
                .status(status)
                .body(ApiResponse.error(
                        status.is2xxSuccessful(),
                        error,
                        path,
                        status.value()
                ));
    }
}
