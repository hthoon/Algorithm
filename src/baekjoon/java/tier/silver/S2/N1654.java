package baekjoon.java.tier.silver.S2;

import java.io.*;
import java.util.*;

public class N1654 {
    /**
     * 랜선 자르기 - 이분탐색
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 10000, K <= N
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 10000000

        /* 보유 케이블 목록, 최장 케이블 길이 저장 */
        long[] cables = new long[K];
        long maxLength = 0;
        for (int i = 0; i < K; i++) {
            long cable = Integer.parseInt(br.readLine());
            cables[i] = cable;
            if (cable > maxLength) {
                maxLength = cable;
            }
        }

        /* 탐색 대상: 케이블의 길이 */
        long left = 1;           // 케이블 최소 길이
        long right = maxLength;  // 케이블 길이 상한
        long answer = 0;         // 문제의 조건을 충족하는 케이블의 길이

        /* 루프 하단의 left, right 조정을 통해 하나의 값에 수렴한다. */
        while (left <= right) {
            long mid = left + (right - left) / 2; //
            long qt = 0;

            for (long cable : cables) {
                qt += cable / mid;
            }

            // qt 충족 시, 길이를 늘려 재탐색
            if (qt >= N) {
                answer = mid;
                left = mid + 1;
            }
            // qt 불충족 시: 길이를 줄여 재탐색
            else {
                right = mid - 1;
            }
        }
        System.out.print(answer);
    }
}
