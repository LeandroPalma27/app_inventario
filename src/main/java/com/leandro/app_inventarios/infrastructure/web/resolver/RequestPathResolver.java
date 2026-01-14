package com.leandro.app_inventarios.infrastructure.web.resolver;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestPathResolver {
    public static String currentPath() {
        return ((ServletRequestAttributes)
                RequestContextHolder.currentRequestAttributes())
                .getRequest()
                .getRequestURI();
    }
}
