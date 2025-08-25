package baekjoon.java.tier.silver.S2;

import java.io.*;
import java.util.*;

public class N9184 {
    /**
     * 신나는 함수 실행 - DP
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        * if a <= 0 or b <= 0 or c <= 0, then w(a, b, c)
        *   returns: 1
        * if a > 20 or b > 20 or c > 20, then w(a, b, c)
        *   returns: w(20, 20, 20)
        * if a < b and b < c, then w(a, b, c)
        *   returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        * otherwise it
        *   returns: w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        * */

        /*
        * - 0이 포함된 경우 및 음수 범위는 전부 1이다.
        * - 양수 범위는 20까지다.
        * */

        int[][][] dp = new int[20 + 1][20 + 1][20 + 1];

        for (int a = 0; a <= 20; a++) {
            for (int b = 0; b <= 20; b++) {
                for (int c = 0; c <= 20; c++) {
                    if (a == 0 || b == 0 || c == 0) {
                        dp[a][b][c] = 1;
                    }
                    else if (a < b && b < c) {
                        dp[a][b][c] = dp[a][b][c - 1] + dp[a][b - 1][c - 1] - dp[a][b - 1][c];
                    }
                    else {
                        dp[a][b][c] = dp[a - 1][b][c] + dp[a - 1][b - 1][c] + dp[a - 1][b][c - 1] - dp[a - 1][b - 1][c - 1];
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                System.out.print(answer);
                return;
            }
            else if (a <= 0 || b <= 0 || c <= 0) {
                answer.append(formatting(a, b, c, 1));
            }
            else if (a > 20 || b > 20 || c > 20) {
                answer.append(formatting(a, b, c, dp[20][20][20]));
            }
            else {
                answer.append(formatting(a, b, c, dp[a][b][c]));
            }
        }
    }

    // 재귀로 나타냈을 때의 w(a, b, c)
    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;

        else if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);

        else if (a < b && b < c) return w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

        else return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    private static String formatting(int a, int b, int c, int result) {
        return String.format("w(%d, %d, %d) = %d\n", a, b, c, result);
    }
}
