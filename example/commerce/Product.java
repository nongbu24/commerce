package com.example.commerce;

public class Product {
    // 속성
    private String productName;
    private int productPrice;
    private String productDescription;
    private int productStock;

    // 생성자
    public Product(String name, int price, String description, int stock) {
        this.productName = name;
        this.productPrice = price;
        this.productDescription = description;
        this.productStock = stock;
    }

    // 기능
    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProductStock() {
        return productStock;
    }
}
