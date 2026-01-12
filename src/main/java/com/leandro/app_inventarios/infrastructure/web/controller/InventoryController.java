package com.leandro.app_inventarios.infrastructure.web.controller;

import com.leandro.app_inventarios.features.inventory.application.port.in.CreateProductUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.in.GetProductByIdUseCase;
import com.leandro.app_inventarios.features.inventory.application.port.in.ListProductUseCase;
import com.leandro.app_inventarios.features.inventory.domain.model.Product;
import com.leandro.app_inventarios.infrastructure.web.dto.request.CreateProductRequest;
import com.leandro.app_inventarios.infrastructure.web.dto.response.ApiResponse;
import com.leandro.app_inventarios.infrastructure.web.dto.response.ProductResponse;
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
    public List<Product> listAll() {
        return listProductsUseCase.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getById(
            @PathVariable Long id, HttpServletRequest httpServletRequest) {

        Product product = getProductByIdUseCase.findById(id);

        return ResponseEntity.ok(
                ApiResponse.success(ProductResponse.from(product), httpServletRequest.getRequestURI())
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(@RequestBody CreateProductRequest request, HttpServletRequest httpServletRequest) {
        Product saved = createProductUseCase.execute(request.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.success(
                        ProductResponse.from(saved),
                        httpServletRequest.getRequestURI()
                )
        );
    }
}
