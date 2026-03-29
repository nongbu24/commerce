package com.example.commerce;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CommerceSystem {
    private List<Product> products = new ArrayList<>();

    public void start() {
        // 숫자 3자리마다 쉼표 찍기
        DecimalFormat df = new DecimalFormat("#,###");

        Product product0 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 1);
        Product product1 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 1);
        Product product2 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 1);
        Product product3 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 1);

        products.add(product0);
        products.add(product1);
        products.add(product2);
        products.add(product3);

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            // printf 문 사용하여 작성, 변수에 할당된 값을 포함한 공백을 주어 출력 화면을 정리함
            System.out.printf("%d. %-11s | %9s원 | %s\n",
                    (i + 1),
                    product.getProductName(),
                    df.format(product.getProductPrice()),
                    product.getProductInformation()
            );
        }

        System.out.printf("0. %-10s | 프로그램 종료\n", "종료");
    }
}
