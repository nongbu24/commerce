package com.example.commerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommerceSystem commerceSystem = new CommerceSystem();

        while (true) {
            try {
                commerceSystem.start();
                int select = sc.nextInt();

                if (select == 1) {

                }
                if (select == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");

                    break;
                }
            // 문자를 입력했을 때 출력
            } catch (InputMismatchException e) {
                System.out.println("올바른 번호를 입력해 주세요.\n");
                sc.nextLine();  // 잘못된 입력 버퍼 지우기
            }
        }
    }
}
