package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.*;

public class N17626 {
    /**
     * Four Squares
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 50000

        /*
        * 1 -> 1
        * 2 -> 1 + 1
        * 3 -> 1 + 1 + 1
        * 4 -> 2^2
        * 5 -> 2^2 + 1
        * 6 -> 2^2 + 1 + 1
        * 7 -> 2^2 + 1 + 1 + 1
        * 8 -> 2^2 + 2^2
        * 9 -> 3^2
        *
        * 0. 라그랑주 4제곱수 정리에 따라, 요소 수의 최솟값을 구하기 위해 배열을 4로 채운다.
        * 1. i에서 제곱수를 뺀 x를 구한다. -> x = 1 - 제곱수
        * 2. dp[x]는 과거의 값이다. 이 값에 1을 더하면 현 제곱수를 사용했을 때 요소의 수다.
        * 3. 제곱근을 1씩 늘리며 최소가 되는 요소의 수를 구한다.
        * ==> dp[i] = min(dp[i], dp[i - j * j] + 1)
        * */

        /* 라그랑주 4제곱수 정리에 따라 상한값 설정 */
        int[] elements = new int[n + 1];
        Arrays.fill(elements, 4);
        elements[0] = 0;                    // 주의: 초기화하지 않으면 정상적인 비교 불가

        /* DP 채우기 */
        for (int i = 1; i <= n; i++) {
            /* i에서 제곱수를 빼서 얻은 과거의 값과 비교 */
            for (int j = 1; j * j <= i; j++) {
                elements[i] = Math.min(elements[i], elements[i - j * j] + 1);
            }
        }
        System.out.print(elements[n]);
    }
}
