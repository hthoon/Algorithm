package baekjoon.java.tier.bronze.B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N24416 {
    /**
     * 알고리즘 수업 - 피보나치 수 1 - DP
     */
    static int countRecur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 5 <= n <= 40

        /* DP */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        int countDp = 0;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            countDp++;
        }

        /* 재귀 */
        countRecur = 0;
        fiboRecur(n);

        System.out.printf("%d %d", countRecur, countDp);
    }

    private static int fiboRecur(int n) {
        // 기저 사례를 만났을 때만 카운팅한다.
        if (n == 1 || n == 2) {
            countRecur++;
            return 1;
        }
        return fiboRecur(n - 2) + fiboRecur(n - 1);
    }
}
