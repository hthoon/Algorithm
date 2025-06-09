package baekjoon.java.stepbystep.S11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24264 {
/**
 * 시간복잡도 - O(n^2)
 * */
    public static void main(String[] args) throws IOException {
        /*
         * MenOfPassion(A[], n) {
         *     sum <- 0;
         *     for i <- 1 to n
         *         for j <- 1 to n
         *             sum <- sum + A[i] × A[j]; # 코드1
         *     return sum;
         * }
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력값 범위 주의!
        long n = Long.parseLong(br.readLine());

        System.out.printf("%d\n2", n * n);
    }
}


