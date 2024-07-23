package java_algorithm.doit_begin.chapter5;

import java.util.Scanner;

public class Q3_GCDArray {

    static int gcd(int x, int y) {
        while (y != 0) { // 반복조건1: y가 0이 아닌 경우
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    static int gcdArray(int[] array, int start, int quan) {
        // for 쓰는 방법 있나.

        // 요소가 한 개면 자기자신이 최대공약수
        if (quan == 1)
            return array[start];

        // 요소가 두 개이면 gcd에 두 수를 대입
        else if (quan == 2)
            return gcd(array[start], array[start + 1]);

        // 요소가 3개 이상인 경우, 처음부터 끝까지 n번째, n + 1번째 요소의 최대공약수를 구한다.
        else
            return gcd(array[start], gcdArray(array, start + 1, quan - 1));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("최대공약수를 구할 숫자의 수 입력: ");
            n = input.nextInt();
            if (n <= 0)
                System.out.println("1 이상의 수 입력");
        } while (n < 1);

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            array[i] = input.nextInt();
        }

        System.out.printf("최대공약수는 %d입니다.", gcdArray(array, 0, n));
    }
}
