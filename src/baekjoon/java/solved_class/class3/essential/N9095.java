package baekjoon.java.solved_class.class3.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095 {
    /**
     * 1, 2, 3 더하기
     * TODO: 규칙성 제외, 원리는 잘 와닿지 않음.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        /* 주의: 순열을 구해야 함. -> 순서 고려 */

        int[] dp = new int[n + 1];
        dp[1] = 1; // 1
        dp[2] = 2; // 1 1,     2
        dp[3] = 4; // 1 1 1,   2 1,   3
        dp[4] = 7; // 1 1 1 1, 2 1 1, 2 2, 3 1 => dp[1] + dp[2] + dp[3]

        for (int i = 1; i <= n; i++) {
            dp[n] = dp[n - 3] + dp[n - 2] + dp[n - 1];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
