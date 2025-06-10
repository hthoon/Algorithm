package baekjoon.java.stepbystep.S12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2231 {
    /**
     * 분해합
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
        * M의 분해합 N -> M은 N의 생성자
        * ex) 245 -> 245 + 2 + 4 + 5 = 256
        * --> 245는 256의 생성자
        * */

        /* N의 자릿수 구하기 */
        int digits = 1;
        while (N / mul(10, digits) != 0) {
            digits++;
        }

        /*
         * 자릿수 구하기 대안
         * <br>
         * 1. String 메서드 활용
         * int digits = String.valueOf(N).length;
         * <br>
         * 2. 반복문
         * do {
         *     N /= 10;
         *     digits++;
         * } while (N > 0);
         * */

        int startPoint = Math.max(1, N - digits * 9);
        int result;

        for (int i = startPoint; i < N; i++) {

            int sum = 0;
            int num = i;

            for (int j = 1; j <= digits; j++) {
                sum += num % 10;
                num /= 10;
            }

            result = i + sum;

            if (result == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    /* 제곱수 구하기 */
    private static int mul(int tar, int num) {
        if (num == 0) {
            return 1;
        }

        return tar * mul(tar, num - 1);
    }

    /* 잘못 구현한 제곱수 구하기. 항상 결과가 1임
    private int mul(int tar, int num) {
        if (num == 0) {
            return 1;
        }

        return mul(tar * 10, num - 1);
    }
    */
}
