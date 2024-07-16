package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q7_Gauss {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("1부터 n까지의 합");
        System.out.print("n값: ");
        int n = input.nextInt();

        System.out.println("1부터 " + n + "까지의 합은 " + gauss1(n));

        System.out.println("1부터 " + n + "까지의 합은 " + gauss2(n));
        }

    static int gauss1(int n) {
        // 반복문 사용
        int sum = 0;

        for (int i = 0; i < n / 2; i++) {
            sum += (1 + n);
        }

        if (n % 2 != 0) {
            sum += (n + 1) / 2;
        }

        return sum;
    }

    static int gauss2(int n) {
        int sum = 0;

        sum = (1 + n) * (n / 2);

        if (n % 2 != 0) {
            sum += (n + 1) / 2;
        }

        return sum;
    }
}
