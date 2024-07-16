package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q14_Triangle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("변의 길이: ");
        int n = input.nextInt();

        triangleLB(n);
        System.out.println();

        triangleLU(n);
        System.out.println();

        triangleRB(n);
        System.out.println();

        triangleRU(n);
    }

    // 왼쪽 아래가 직각
    static void triangleLB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    // 왼쪽 위가 직각
    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }

    // 오른쪽 위가 직각
    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= n - i - 1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }

    // 오른쪽 아래가 직각
    static void triangleRB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
