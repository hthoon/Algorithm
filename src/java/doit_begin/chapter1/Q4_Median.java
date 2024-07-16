package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q4_Median {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println("중위값: " + median(a, b, c));
    }

    static int median(int a, int b, int c) {
        // 1. a >= b
        if (a >= b) {
            if (b >= c) return b;
            else if (a <= c) return a;
            else return c;
            }
        else if (a > c) return a;
        else if (b > c) return c;
        else return b;
    }

    // Q5 예제. 비교 횟수가 최대 3번인 위 메서드와 달리, 2n번 및 최대 8번까지 이루어질 수 있음.
    static int median_2(int a, int b, int c) {
        if ((b >= a && c <= a) || (b <= a && c >= a)) return a;
        else if ((a > b && c < b) || (a < b && c > b)) return b;
        return c;
    }

}
