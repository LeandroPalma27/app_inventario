package com.leandro.app_inventarios.infrastructure.web.dto.response;

public record ApiResponse<T>(
        T data,
        ApiMeta meta,
        ApiError error
) {
    public static <T> ApiResponse<T> success(T data, String path) {
        return new ApiResponse<>(
                data,
                ApiMeta.now(path),
                null
        );
    }

    public static <T> ApiResponse<T> error(ApiError error, String path) {
        return new ApiResponse<>(
                null,
                ApiMeta.now(path),
                error
        );
    }
}
