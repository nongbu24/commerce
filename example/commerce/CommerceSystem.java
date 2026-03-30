package com.example.commerce;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories = new ArrayList<>();

    // 생성자가 호출되면 categories 리스트에 카테고리 이름이 들어감
    public CommerceSystem() {
        setCategories();
    }

    public void start() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");

        // 저장된 카테고리 리스트 출력
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);

            System.out.println((i + 1) + ". " + category.getCategoryName());
        }

        System.out.printf("0. %-10s | 프로그램 종료\n", "종료");
    }

    // 카테고리 리스트에 이름 삽입
    public void setCategories() {
        Category category0 = new Category("전자제품");
        Category category1 = new Category("의류");
        Category category2 = new Category("식품");

        categories.add(category0);
        categories.add(category1);
        categories.add(category2);
    }

    // 카테고리 안에 제품 정보 삽입
    public void inputCategory() {
        Category electronics = new Category("전자제품");
        Category clothes = new Category("의류");
        Category foods = new Category("식품");

        electronics.addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 1));
        electronics.addProduct(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 1));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 1));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 1));

        clothes.addProduct(new Product("상의", 30000, "멋진 웃도리", 1));
        clothes.addProduct(new Product("상의", 30000, "멋진 옷", 1));
        clothes.addProduct(new Product("하의", 30000, "멋진 바지", 1));
        clothes.addProduct(new Product("하의", 30000, "멋진 치마", 1));

        foods.addProduct(new Product("사과", 3000, "사과는 맛있어", 1));
        foods.addProduct(new Product("바나나", 5000, "맛있으면 바나나", 1));
    }

    // 카테고리 선택

}
