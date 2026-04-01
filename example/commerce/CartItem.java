package com.example.commerce;

// 카트에 들어있는 상품 정보
public class CartItem {
    // 속성
    private Product product;
    private int quantity;

    // 생성자
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // 기능
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }
}
