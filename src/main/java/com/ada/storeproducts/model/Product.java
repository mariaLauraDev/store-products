package com.ada.storeproducts.model;

public class Product {
    private int productId;
    private String name;
    private String description;
    private Double price;
    private String category;
    private int stock;

    public Product(int productId, String name, String description, Double price, String category, int stock) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public Product() {

    }

    public Product(int  productId, String name, String description, Double price, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return  productId;
    }

    public void setId(int  productId) {
        this. productId =  productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

