package com.leandro.app_inventarios.features.inventory.domain.model;

public class Product {
    private final Long id;
    private final String name;
    private int stock;

    public Product(Long id, String name, int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock inválido");
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public void adjustStock(int amount) {
        if (stock + amount < 0) throw new IllegalStateException("Stock insuficiente");
        stock += amount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
