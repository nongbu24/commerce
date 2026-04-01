package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

// 사용자가 선택한 상품을 장바구니에 추가할 수 있는 기능을 제공
public class Cart {
    // 속성
    private List<CartItem> cartItems = new ArrayList<>();

    // 생성자

    // 기능
    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
