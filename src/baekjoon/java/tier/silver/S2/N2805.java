package baekjoon.java.tier.silver.S2;

import java.io.*;
import java.util.*;

public class N2805 {
    /**
     * 나무 자르기 - 이분 탐색
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1000000, 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 2000000000, 필요한 나무의 길이

        long[] trees = new long[N];
        long maxHeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long tree = Long.parseLong(st.nextToken());
            trees[i] = tree;
            if (tree > maxHeight) {
                maxHeight = tree;
            }
        }

        /* 적어도 M미터의 나무를 집에 가져가기 위해, 절단기의 높이 H의 최댓값을 구해야 한다. */
        long left = 0;
        long right = maxHeight;
        long H = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long qt = 0;

            /* 절단된 나무 길이 누적 */
            for (int i = 0; i < N; i++) {
                // 주의: 양수 판별하지 않으면 음수 결과까지 누적된다.
                if (trees[i] - mid > 0) {
                    qt += trees[i] - mid;
                }
            }

            // 나무의 양이 넉넉하면 현재 절단기 높이를 저장하고, 높여서 다시 탐색한다.
            if (qt >= M) {
                left = mid + 1;
                H = mid;
            }
            // 나무가 부족하면 절단기 높이를 낮춰서 다시 탐색한다.
            else {
                right = mid - 1;
            }
        }
        System.out.print(H);
    }
}
