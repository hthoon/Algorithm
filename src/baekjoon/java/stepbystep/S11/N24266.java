package baekjoon.java.stepbystep.S11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24266 {
/**
 * 시간복잡도 - O(n^3)
 * */
    public static void main(String[] args) throws IOException {
        /*
         * MenOfPassion(A[], n) {
         *     sum <- 0;
         *     for i <- 1 to n
         *         for j <- 1 to n
         *             for k <- 1 to n
         *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
         *     return sum;
         * }
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력값 범위 주의!
        long n = Long.parseLong(br.readLine());

        // 외부 반복문 -> n회 실행
        // 중간 반복문 -> n회 실행
        // 내부 반복문 -> n회 실행
        // ==> n * n * n = n^3

        System.out.printf("%d\n3", n * n * n);
    }
}


