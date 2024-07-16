package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q9_CovLoop {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;
        int result = 0;

        System.out.print("a 입력: ");
        a = input.nextInt();

        while (true) {
            System.out.print("a 입력: ");
            b = input.nextInt();
            if (b > a) {
                System.out.println("b - a = " + (b - a));
                break;
            }
            System.out.println("a보다 큰 값을 입력하세요");
        }

    }

}
