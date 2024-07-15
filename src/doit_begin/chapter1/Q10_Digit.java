package doit_begin.chapter1;

import java.util.Scanner;

public class Q10_Digit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;

        do {
            System.out.print("n 입력: ");
            n = input.nextInt();
        }
        while (n <= 0); // 양의 정수가 나올 때까지 반복

        int count = 0;
        while (n > 0) {
            n /= 10;
            count++; // 10으로 한 번 나누기 -> 자릿수 1 증가.
        }

        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
