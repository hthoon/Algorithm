package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q6_While {

    public static void main(String[] args) {
        // 반복
        Scanner input = new Scanner(System.in);

        System.out.println("1부터 n까지의 합");
        System.out.print("n값: ");
        int n = input.nextInt();

        // While 반복문 구현
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("1부터 " + n + "까지의 합은 " + sum);
    }
}
