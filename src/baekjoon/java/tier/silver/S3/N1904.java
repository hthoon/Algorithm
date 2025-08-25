package baekjoon.java.tier.silver.S3;

import java.io.*;

public class N1904 {
    /**
     * 01타일 - DP
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100000

        /* 00 00 00 */
        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 1; // 1
        dp[2] = 2; // 00,    11
        dp[3] = 3; // 001,   100
        dp[4] = 5; // 0000,  0011,  1100,  1001,  1111
        dp[5] = 8; // 00001, 00111, 11001, 10011, 11111, 10000, 00100, 11100

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
        }
        System.out.print(dp[N]);
    }
}
