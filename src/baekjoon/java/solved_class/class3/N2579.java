package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.*;

public class N2579 {
    /**
     * 계단 오르기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine()); // 1 <= N <= 300

        /* 계단 배열 */
        int[] stairs =  new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        /* early return */
        if (N == 1) {
            System.out.print(stairs[1]);
            return;
        }

        /* DP 배열 생성 및 초기값 설정 */
        int[] scoreBoard = new int[N + 1];
        // 1. 시작점에서 1칸
        scoreBoard[1] = stairs[1];
        // 2. 시작점에서 2칸
        scoreBoard[2] = stairs[1] + stairs[2];

        if (N >= 3) {
            // 3. 시작점에서 3칸 - 2칸 + 1칸, 1칸 + 2칸
            scoreBoard[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

            for (int i = 4; i <= N; i++) {
                /* 각 방법의 최댓값 비교 */
                // i - 2칸에서 2칸 점프, i - 3칸에서 2칸 점프 + 1칸 점프
                scoreBoard[i] = Math.max(scoreBoard[i - 2] + stairs[i], scoreBoard[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }
        System.out.print(scoreBoard[N]);
    }
}
