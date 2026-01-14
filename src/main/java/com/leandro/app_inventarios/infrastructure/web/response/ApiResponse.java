package com.leandro.app_inventarios.infrastructure.web.response;

public record ApiResponse<T>(
        boolean success,
        T data,
        ApiMeta meta,
        ApiError error
) {
    public static <T> ApiResponse<T> success(boolean success, T data, String path, int status) {
        return new ApiResponse<>(
                success,
                data,
                ApiMeta.now(path, status),
                null
        );
    }

    public static <T> ApiResponse<T> error(boolean success, ApiError error, String path, int status) {
        return new ApiResponse<>(
                success,
                null,
                ApiMeta.now(path, status),
                error
        );
    }
}
