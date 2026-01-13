package com.leandro.app_inventarios.infrastructure.web.rest;

import com.leandro.app_inventarios.features.inventory.domain.exception.NotFoundException;
import com.leandro.app_inventarios.infrastructure.web.response.ApiError;
import com.leandro.app_inventarios.infrastructure.web.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // -------------------------
    // 400 - BAD REQUEST
    // -------------------------
    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class
    })
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(
            Exception ex,
            HttpServletRequest request
    ) {
        return buildError(
                HttpStatus.BAD_REQUEST,
                "BAD_REQUEST",
                "Invalid request",
                ex,
                request
        );
    }

    // -------------------------
    // 404 - NOT FOUND (only uri PATH)
    // -------------------------
    @ExceptionHandler({
        NoResourceFoundException.class,
    })
    public ResponseEntity<ApiResponse<Void>> handleNoHandlerFound(NoResourceFoundException ex, HttpServletRequest request) {
        return buildError(
            HttpStatus.NOT_FOUND,
            "ENDPOINT_NOT_FOUND",
            ex.getMessage(),
            ex,
            request
        );
    }

    // -------------------------
    // 404 - NOT FOUND (entity-domain resource)
    // -------------------------
    @ExceptionHandler({
        NotFoundException.class,
    })
    public ResponseEntity<ApiResponse<Void>> customHandleNotFound(NotFoundException ex, HttpServletRequest request) {
        return buildError(
                HttpStatus.NOT_FOUND,
                ex.getCode(),
                ex.getMessage(),
                ex,
                request
        );
    }
    @ExceptionHandler({
        NoSuchElementException.class
    })
    public ResponseEntity<ApiResponse<Void>> handleNoSuchElement(NoSuchElementException ex, HttpServletRequest request) {
        return buildError(
                HttpStatus.NOT_FOUND,
                "RESOURCE_NOT_FOUND",
                ex.getMessage(),
                ex,
                request
        );
    }

    // -------------------------
    // 500 - INTERNAL ERROR
    // -------------------------
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneric(
            Exception ex,
            HttpServletRequest request
    ) {
        return buildError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "INTERNAL_ERROR",
                "Unexpected error occurred",
                ex,
                request
        );
    }

    // -------------------------
    // Helper común
    // -------------------------
    private ResponseEntity<ApiResponse<Void>> buildError(
        HttpStatus status,
        String code,
        String message,
        Exception ex,
        HttpServletRequest request
    ) {
        ApiError error = new ApiError(code, message);

        return ResponseEntity
            .status(status)
            .body(
                ApiResponse.error(
                    error,
                    request.getRequestURI(),
                    status.value()
                )
            );
    }
}
