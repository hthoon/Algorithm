package java_algorithm.doit_begin.chapter5;

import java.util.Scanner;

public class Q1_Factorial {

    static int factorial(int n) {
        int result = 1;

        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        do {
            n = input.nextInt();
            input.nextLine();
            if (n < 0) {
                System.out.println("0 이상의 정수 입력 필요");
            }
        } while (n < 0);

        System.out.printf("%d! 결과: %d", n, factorial(n));
    }
}
