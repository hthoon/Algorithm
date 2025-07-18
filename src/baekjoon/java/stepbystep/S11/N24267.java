package baekjoon.java.stepbystep.S11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24267 {
/**
 * 시간복잡도 - O(n^3)
 * 문제의 삼중 루프가 '서로 다른 3개의 인덱스 중 3개를 택하는 구조' 임을 이용한다.
 * */
    public static void main(String[] args) throws IOException {
        /*
         * MenOfPassion(A[], n) {
         *     sum <- 0;
         *     for i <- 1 to n - 2
         *         for j <- i + 1 to n - 1
         *             for k <- j + 1 to n
         *                 sum <- sum + A[i] × A[j] × A[k]; # 코드1
         *     return sum;
         * }
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력값 범위 주의!
        long n = Long.parseLong(br.readLine());

        // 외부 반복문 -> n - 2회 실행
        // 중간 반복문 -> n - i - 1회 실행 || (n - 1) - (i + 1) + 1
        // 내부 반복문 -> n회 실행 || n - (j + 1)
        // ==> nC3과 같다.

        // nC3 => n(n - 1)(n - 2) / 6

        System.out.printf("%d\n3", n * (n - 1) * (n - 2) / 6);
    }
}


