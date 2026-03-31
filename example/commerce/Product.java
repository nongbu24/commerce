package com.example.commerce;

// 개별 상품을 관리하는 클래스
public class Product {
    // 속성
    private String name;
    private int price;
    private String description;
    private int quantity;

    // 생성자
    public Product(String name, int price, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    // 기능
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }
}
