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
    public ResponseEntity<ApiResponse<List<ProductResponse>>> listAll() {
        List<ProductResponse> products = listProductsUseCase.listAll().stream().map(ProductResponse::from).toList();
        return ApiResponseFactory.buildSuccess(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getById(@PathVariable Long id) {
        Product product = getProductByIdUseCase.findById(id);
        return ApiResponseFactory.buildSuccess(ProductResponse.from(product), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(@RequestBody CreateProductRequest request) {
        Product saved = createProductUseCase.execute(request.toCommand());
        return ApiResponseFactory.buildSuccess(ProductResponse.from(saved), HttpStatus.CREATED);
    }
}
