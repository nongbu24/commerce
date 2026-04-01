package com.example.commerce;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


//커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스
public class CommerceSystem {
    //속성
    private List<Category> categories = new ArrayList<>();
    private Cart cart = new Cart();

    Scanner sc = new Scanner(System.in);
    // 숫자 3자리마다 ',' 출력
    DecimalFormat df = new DecimalFormat("#,###");

    // 생성자
    // 생성자가 호출되면 categories 리스트에 카테고리 이름이 추가됨
    public CommerceSystem() {
        Category electronic = new Category("전자제품");
        Category cloth = new Category("의류");
        Category food = new Category("식품");

        categories.add(electronic);
        categories.add(cloth);
        categories.add(food);
    }

    // 기능
    // 실시간 커머스 플랫폼 메인 화면 출력
    public void start() {
        while(true) {
            try {
                System.out.println("[ 실시간 커머스 플랫폼 메인 ]");

                // 카테고리 출력
                for (int i = 0; i < categories.size(); i++) {
                    Category category = categories.get(i);

                    System.out.println((i + 1) + ". " + category.getName());
                }

                System.out.printf("0. %-10s | 프로그램 종료\n", "종료");

                // 장바구니에 물건이 들어있을 때만 출력됨
                if (!cart.getCartItems().isEmpty()) {
                    System.out.println();
                    System.out.println("[ 주문 관리 ]");
                    System.out.println("4. 장바구니 확인 | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. 주문 취소    | 진행 중인 주문을 취소합니다.");
                }

                int select = sc.nextInt();

                // 0을 입력받으면 커머스 플랫폼 종료
                if (select == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");

                    break;
                }

                // 카트에 물건이 들어있는 상태에서 4번을 입력받았을 때
                if (select == 4 && !cart.getCartItems().isEmpty()) {
                    showCart();

                    continue;
                }

                // 카트에 물건이 들어있는 상태에서 5번을 입력받았을 때
                if (select == 5 && !cart.getCartItems().isEmpty()) {
                    deleteCart();

                    continue;
                }

                int categoryIndex = select - 1;

                // 목록에 없는 번호를 입력받으면 오류 출력
                if (categoryIndex < 0 || categoryIndex >= categories.size()) {
                    throw new IllegalArgumentException("해당 카테고리가 없습니다.\n");
                }

                // 선택한 카테고리에 있는 상품 출력
                selectCategory(categoryIndex);

            // 문자를 입력받았을 때 오류 출력
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.\n");

                // 잘못 입력된 버퍼 지우기
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 선택된 카테고리에 있는 상품 출력
    public void selectCategory(int selectCategory) {
        while(true) {
            try {
                Category category = categories.get(selectCategory);

                System.out.println("\n[ " + category.getName() + " 카테고리 ]");

                // 선택한 카테고리의 상품 정보 출력
                for (int i = 0; i < category.getProducts().size(); i++) {
                    Product product = category.getProducts().get(i);

                    System.out.printf("%d. %-13s | %9s원 | %s\n",
                            (i + 1),
                            product.getName(),
                            df.format(product.getPrice()),
                            product.getDescription()
                    );
                }

                System.out.println("0. 뒤로 가기");

                int select = sc.nextInt();

                // 0을 입력받으면 뒤로 가기
                if (select == 0) {
                    System.out.println();

                    break;
                }

                int productIndex = select - 1;

                try {
                    // 화면에 출력되지 않은 번호를 입력받았을 때 발생하는 오류
                    if (productIndex < 0 || productIndex >= category.getProducts().size()) {
                        throw new IllegalArgumentException("유효하지 않은 상품 번호입니다.");
                    }

                    // 선택한 번호의 상품 출력
                    Product product = category.getProducts().get(productIndex);

                    // 선택한 번호의 상품 정보 출력
                    System.out.printf("선택된 상품: %-10s | %9s원 | %-10s | 재고: %d개\n\n",
                            product.getName(),
                            df.format(product.getPrice()),
                            product.getDescription(),
                            product.getQuantity()
                    );

                    cart(selectCategory, productIndex);

                    return;
                // 문자를 입력받았을 때 오류 출력
                } catch (InputMismatchException e) {
                    System.out.println("유효한 번호를 입력해주세요.");

                    // 잘못 입력된 버퍼 제거
                    sc.nextLine();
                // 화면에 출력되지 않은 번호를 입력받았을 때 오류 출력
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            // 문자를 입력받았을 때 오류 출력
            } catch(InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.");

                sc.nextLine();
            // 목록에 없는 숫자를 입력받으면 오류 출력
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 상세 카테고리의 상품 페이지에서 선택한 상품을 장바구니에 넣음
    public void cart(int selectCategory, int selectProduct) {
        while(true) {
            try {
                Category category = categories.get(selectCategory);
                Product product = category.getProducts().get(selectProduct);

                System.out.printf("\"%-10s | %9s원 | %s\"\n",
                        product.getName(),
                        df.format(product.getPrice()),
                        product.getDescription()
                );

                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                System.out.printf("1. %-10s 2. 취소\n", "확인");

                int select = sc.nextInt();

                if (select == 1) {
                    // 재고가 없으면 장바구니에 넣지 않음
                    if (product.getQuantity() <= 0) {
                        System.out.println("선택한 상품의 재고가 없습니다.\n");

                        return;
                    }

                    // 장바구니에 이미 있는 상품인지 확인 (중복 투입 방지)
                    boolean found = false;

                    for (CartItem item : cart.getCartItems()) {
                        if (item.getProduct().equals(product)) {
                            // 상품을 재고보다 많이 담았을 때 오류 출력
                            if (item.getQuantity() >= product.getQuantity()) {
                                System.out.println("재고보다 더 담을 수 없습니다.\n");

                                return;
                            }

                            item.addQuantity(1);
                            found = true;

                            break;
                        }
                    }

                    // 장바구니에 없는 상품이면 새로 추가
                    if (!found) {
                        cart.getCartItems().add(new CartItem(product, 1));
                    }

                    System.out.println(product.getName() + "가 장바구니에 추가되었습니다.\n");

                    return;
                } else if (select == 2) {
                    System.out.println("취소되었습니다. 카테고리 선택 화면으로 돌아갑니다.\n");

                    return;
                // 1 또는 2가 아닌 숫자를 입력받았을 때 오류 발생
                } else {
                    throw new IllegalArgumentException("유효하지 않은 번호입니다.\n");
                }
            // 문자를 입력받았을 때 오류 출력
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.\n");

                sc.nextLine();
            // 1 또는 2가 아닌 숫자를 입력받았을 때 발생하는 오류 출력
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 장바구니 내역 출력
    public void showCart() {
        while(true) {
            try {
                System.out.println("아래와 같이 주문하시겠습니까?\n");
                System.out.println("[ 장바구니 내역 ]");

                int totalPrice = 0;

                for (int i = 0; i < cart.getCartItems().size(); i++) {
                    CartItem item = cart.getCartItems().get(i);

                    System.out.printf("%-10s | %9s원 | %-10s | 수량: %s개\n",
                            item.getProduct().getName(),
                            df.format(item.getProduct().getPrice()),
                            item.getProduct().getDescription(),
                            item.getQuantity()
                    );

                    totalPrice += item.getProduct().getPrice() * item.getQuantity();
                }
                System.out.println();

                System.out.println("[ 총 주문 금액 ]");
                System.out.println(df.format(totalPrice) + "원");
                System.out.println();

                System.out.println("1. 주문 확정          2. 메인으로 돌아가기");

                int select = sc.nextInt();

                if (select == 1) {
                    completeOrder(totalPrice);

                    return;
                } else if (select == 2) {
                    System.out.println("메인으로 돌아갑니다.\n");

                    return;
                // 목록에 없는 숫자를 입력받았을 때 오류 발생
                } else {
                    throw new IllegalArgumentException("유효하지 않은 입력입니다.\n");
                }
            // 문자를 입력받았을 때 오류 출력
            } catch (InputMismatchException e) {
                System.out.println("유효한 숫자를 입력해주세요.\n");

                // 잘못 입력된 버퍼 삭제
                sc.nextLine();
            // 목록에 없는 숫자를 입력받았을 때 오류 출력
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteCart() {
        cart.getCartItems().clear();

        System.out.println("카트에 들어 있는 상품이 삭제되었습니다.\n");
    }

    public void completeOrder(int totalPrice) {
        System.out.println("주문이 완료되었습니다! 총 금액: " + df.format(totalPrice) + "원\n");

        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();

            int beforeQuantity = product.getQuantity();
            int afterQuantity = beforeQuantity - item.getQuantity();

            product.setQuantity(afterQuantity);

            System.out.println(product.getName() + " 재고가 " + beforeQuantity + "개 → " + afterQuantity + "개로 업데이트 되었습니다.");
        }

        cart.getCartItems().clear();

        System.out.println("\n메인 화면으로 돌아갑니다.\n");
    }
}
