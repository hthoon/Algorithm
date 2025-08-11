package baekjoon.java.solved_class.class3;

import java.io.*;

public class N9461 {
    /**
     * 파도반 수열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        /* DP 배열 생성 */
        long[] dp = new long[100 + 1]; // 1 <= N <= 100
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = dp[1] + dp[4]; // -> 시작

        for (int i = 7; i <= 100; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }
}
