package com.leandro.app_inventarios.infrastructure.web.response;

import java.time.Instant;

public record ApiMeta(
        Instant timestamp,
        String path,
        int status
) {
    public static ApiMeta now(String path, int status) {
        return new ApiMeta(Instant.now(), path, status);
    }
}
