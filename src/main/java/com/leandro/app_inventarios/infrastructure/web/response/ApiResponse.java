package com.leandro.app_inventarios.infrastructure.web.response;

public record ApiResponse<T>(
        T data,
        ApiMeta meta,
        ApiError error
) {
    public static <T> ApiResponse<T> success(T data, String path, int status) {
        return new ApiResponse<>(
                data,
                ApiMeta.now(path, status),
                null
        );
    }

    public static <T> ApiResponse<T> error(ApiError error, String path, int status) {
        return new ApiResponse<>(
                null,
                ApiMeta.now(path, status),
                error
        );
    }
}
