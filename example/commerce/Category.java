package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

// Product 클래스를 관리하는 클래스
public class Category {
    // 속성
    private String name;
    private List<Product> products = new ArrayList<>();

    // 생성자
    public Category(String name) {
        this.name = name;

        if (name.equals("전자제품")) {
            Product product = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 25);
            Product product1 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 30);
            Product product2 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 15);
            Product product3 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50);

            products.add(product);
            products.add(product1);
            products.add(product2);
            products.add(product3);

        } else if (name.equals("의류")) {
            Product product = new Product("상의", 30000, "멋진 웃도리", 1);
            Product product1 = new Product("상의", 30000, "멋진 옷", 1);
            Product product2 = new Product("하의", 30000, "멋진 바지", 1);
            Product product3 = new Product("하의", 30000, "멋진 치마", 1);

            products.add(product);
            products.add(product1);
            products.add(product2);
            products.add(product3);

        } else if (name.equals("식품")) {
            Product product = new Product("사과", 3000, "사과는 맛있어", 1);
            Product product1 = new Product("바나나", 5000, "맛있으면 바나나", 1);

            products.add(product);
            products.add(product1);
        }
    }

    // 기능
    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
