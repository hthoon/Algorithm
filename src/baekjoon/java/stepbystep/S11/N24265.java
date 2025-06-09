package baekjoon.java.stepbystep.S11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24265 {
/**
 * 시간복잡도 - O(n^2)
 * */
    public static void main(String[] args) throws IOException {
        /*
         * MenOfPassion(A[], n) {
         *     sum <- 0;
         *     for i <- 1 to n - 1
         *         for j <- i + 1 to n
         *             sum <- sum + A[i] × A[j]; # 코드1
         *     return sum;
         * }
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력값 범위 주의!
        long n = Long.parseLong(br.readLine());

        // 외부 반복문 -> (n - 1)회 실행
        // 내부 반복문 -> (n - i)회 실행
        // ==> n * (n - 1) / 2

        System.out.printf("%d\n2", n * (n - 1) / 2);
    }
}


