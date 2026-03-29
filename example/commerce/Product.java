package com.example.commerce;

public class Product {
    // 속성
    private String productName;
    private int productPrice;
    private String productInformation;
    private int productStock;

    // 생성자
    public Product(String name, int price, String information, int stock) {
        this.productName = name;
        this.productPrice = price;
        this.productInformation = information;
        this.productStock = stock;
    }

    // 기능
    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductInformation() {
        return productInformation;
    }

    public int getProductStock() {
        return productStock;
    }
}
