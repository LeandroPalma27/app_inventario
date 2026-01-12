package com.leandro.app_inventarios.infrastructure.web.dto.response;

import java.time.Instant;

public record ApiMeta(
        Instant timestamp,
        String path
) {
    public static ApiMeta now(String path) {
        return new ApiMeta(Instant.now(), path);
    }
}
