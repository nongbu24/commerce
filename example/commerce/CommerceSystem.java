package com.example.commerce;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    //속성
    private List<Category> categories = new ArrayList<>();
    private ShoppingCart cart = new ShoppingCart();

    Scanner sc = new Scanner(System.in);
    // 숫자 3자리마다 , 찍어줌
    DecimalFormat df = new DecimalFormat("#,###");

    // 생성자
    // 생성자가 호출되면 categories 리스트에 카테고리 이름이 들어감
    public CommerceSystem() {
        Category electronic = new Category("전자제품");
        Category cloth = new Category("의류");
        Category food = new Category("식품");

        categories.add(electronic);
        categories.add(cloth);
        categories.add(food);
    }

    // 기능
    public void start() {
        // 1. 실시간 커머스 플랫폼 메인 화면 출력
        while (true) {
            try {
                System.out.println("[ 실시간 커머스 플랫폼 메인 ]");

                // 카테고리 리스트 출력
                for (int i = 0; i < categories.size(); i++) {
                    Category category = categories.get(i);

                    System.out.println((i + 1) + ". " + category.getName());
                }

                System.out.printf("0. %-10s | 프로그램 종료\n", "종료");

                int choice = sc.nextInt();

                // 1. 실시간 커머스 플랫폼 메인에서 0을 입력하면 프로그램 종료
                if (choice == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");

                    break;
                }

                int categoryIndex = choice - 1;

                // 1. 실시간 커머스 플랫폼 메인에 없는 숫자를 입력했을 때 발생하는 오류
                if (categoryIndex < 0 || categoryIndex >= categories.size()) {
                    throw new IllegalArgumentException("잘못된 입력입니다.\n");
                }

                System.out.println();
                // 2. 플랫폼 메인에 출력된 번호를 입력하면 해당 번호의 카테고리가 가지고 있는 상품이 출력되게 함
                while (true) {
                    try {
                        Category category = categories.get(categoryIndex);

                        System.out.println("[ " + category.getName() + " 카테고리 ]");
                        // products 출력
                        for (int i = 0; i < category.getProducts().size(); i++) {
                            Product product = category.getProducts().get(i);

                            System.out.printf("%d. %-13s | %9s원 | %s\n",
                                    (i + 1),
                                    product.getName(),
                                    df.format(product.getPrice()),
                                    product.getDescription()
                            );
                        }

                        System.out.println("0. 뒤로가기");

                        int selectProduct = sc.nextInt();

                        // 2. 카테고리 메뉴에서 0을 입력하면 이전 페이지로 돌아감
                        if (selectProduct == 0) {
                            System.out.println();

                            break;
                        }

                        int productIndex = selectProduct - 1;

                        // 2. 상품 목록에 없는 번호를 입력했을 때 발생하는 오류
                        if (productIndex < 0 || productIndex >= category.getProducts().size()) {
                            throw new IllegalArgumentException("유효하지 않은 상품 번호입니다.\n");
                        }

                        // 3. 선택된 상품 출력
                        Product product = category.getProducts().get(productIndex);

                        System.out.printf("선택된 상품: %-10s | %10s원 | %-10s | 재고: %d개\n\n",
                                product.getName(),
                                df.format(product.getPrice()),
                                product.getDescription(),
                                product.getQuantity()
                        );

                        // 4. 선택한 상품을 다시 한 번 보여주고, 장바구니에 추가할지 묻기
                        while (true) {
                            try {
                                System.out.printf("%-10s | %10s원 | %s\n",
                                        product.getName(),
                                        df.format(product.getPrice()),
                                        product.getDescription()
                                        );

                                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인          2. 취소");

                                int accept = sc.nextInt();

                                // 4. 1 또는 2가 아닌 숫자를 입력했을 때 오류 발생
                                if (accept < 1 || accept > 2) {
                                    throw new IllegalArgumentException("유효하지 않은 번호입니다.");
                                }

                                // 5. 선택한 상품을 장바구니에 추가하기
                                if (accept == 1) {
                                    ShoppingCart cart = new ShoppingCart(product.getName(), 1, product.getPrice());

                                    cart.getCart().add(product);
                                    System.out.println(product.getName() + "가 장바구니에 추가되었습니다.\n");

                                    break;
                                }


                            // 4. 상품을 장바구니에 추가할 때 문자를 입력하면 발생하는 오류
                            } catch (InputMismatchException e) {
                                System.out.println("번호를 입력해주세요.");

                                // 잘못 입력된 버퍼 삭제
                                sc.nextLine();
                            // 4. 상품을 장바구니에 추가할 때 올바르지 않은 숫자를 입력하면 발생하는 오류 출력
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    // 2. 상품 목록에서 문자를 입력했을 때 발생하는 오류 출력
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.\n");

                        // 잘못 입력된 버퍼 제거
                        sc.nextLine();
                    // 2. 상품 목록에 없는 번호를 입력했을 때 발생하는 오류 출력
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            // 1. 실시간 커머스 플랫폼 메인에서 문자를 입력했을 때 오류 출력
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.\n");

                // 잘못 입력된 버퍼 제거
                sc.nextLine();
            // 1. 실시간 커머스 플랫폼 메인 목록에 없는 숫자를 입력했을 때 오류 출력
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 선택한 카테고리에 있는 상품 출력
    public void selectProduct() {

    }
}
