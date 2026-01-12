package com.leandro.app_inventarios.features.inventory.domain.model;

import java.time.Instant;

public class Product {
    private Long id;
    private String name;
    private int stock;
    private Instant createdAt;

    public Product(Long id, String name, int stock, Instant createdAt) {
        if (stock < 0) throw new IllegalArgumentException("Stock inválido");
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.createdAt = createdAt;
    }

    public static Product create(String name, int stock, Instant createdAt) {
        return new Product(null, name, stock, createdAt);
    }

    public static Product restore(Long id, String name, int stock, Instant createdAt) {
        return new Product(id, name, stock, createdAt);
    }

    public void adjustStock(int amount) {
        if (stock + amount < 0) throw new IllegalStateException("Stock insuficiente");
        stock += amount;
    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
