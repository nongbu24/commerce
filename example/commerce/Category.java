package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Category {
    // 속성
    private String categoryName;
    private List<Product> products;

    // 생성자
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }

    // 기능
    public void addProduct(Product product) {
        products.add(product);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
