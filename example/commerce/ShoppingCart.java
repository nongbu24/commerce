package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

// 사용자가 선택한 상품을 장바구니에 추가할 수 있는 기능을 제공
public class ShoppingCart {
    // 속성
    private String name;
    private int quantity;
    private int price;
    private List<Product> cart = new ArrayList<>();

    // 생성자
    public ShoppingCart() {

    }

    public ShoppingCart(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // 기능
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public List<Product> getCart() {
        return cart;
    }
}
