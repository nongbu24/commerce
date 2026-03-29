package com.example.commerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CommerceSystem commerceSystem = new CommerceSystem();

        commerceSystem.start();

        int exitNum = sc.nextInt();

        if (exitNum == 0) {
            System.out.println("\n커머스 플랫폼을 종료합니다.");
        }
    }
}
