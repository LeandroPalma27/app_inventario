package com.leandro.app_inventarios.infrastructure.web.controller;

import com.leandro.app_inventarios.features.inventory.application.port.in.CreateProductUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.in.GetProductByIdUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.in.ListProductUseCase;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import com.leandro.app_inventarios.infrastructure.web.request.CreateProductRequest;
import com.leandro.app_inventarios.infrastructure.web.response.ApiResponse;
import com.leandro.app_inventarios.infrastructure.web.response.ApiResponseFactory;
import com.leandro.app_inventarios.infrastructure.web.response.ProductResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    ListProductUseCase listProductsUseCase;
    @Autowired
    CreateProductUseCase createProductUseCase;
    @Autowired
    GetProductByIdUseCase getProductByIdUseCase;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> listAll(HttpServletRequest httpServletRequest) {
        List<ProductResponse> products = listProductsUseCase.listAll()
                .stream()
                .map(ProductResponse::from)
                .toList();
        return ApiResponseFactory.success(products, httpServletRequest.getRequestURI(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getById(
            @PathVariable Long id, HttpServletRequest httpServletRequest) {
        Product product = getProductByIdUseCase.findById(id);
        return ApiResponseFactory.success(
            ProductResponse.from(product),
            httpServletRequest.getRequestURI(),
            HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(@RequestBody CreateProductRequest request, HttpServletRequest httpServletRequest) {
        Product saved = createProductUseCase.execute(request.toCommand());
        return ApiResponseFactory.success(
            ProductResponse.from(saved),
            httpServletRequest.getRequestURI(),
            HttpStatus.CREATED
        );
    }
}
