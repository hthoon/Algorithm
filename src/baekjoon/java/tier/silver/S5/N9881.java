package baekjoon.java.tier.silver.S5;

import java.io.*;

public class N9881 {
    /**
     * Ski Course Design - 완전 탐색
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000

        int[] hills = new int[N];
        int maxHeight = 0;
        int minHeight = 100;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            hills[i] = height;
            if (height > maxHeight) maxHeight = height;
            if (height < minHeight) minHeight = height;
        }

        if (maxHeight - minHeight <= 17) {
            System.out.print(0);
            return;
        }

        /*
         * 최대 단차를 17로 만드는 최소 비용 구하기
         * 하나의 언덕을 조정하는 비용은 k^2
         * */

        // 100 - 17 = 83이므로, 83까지 탐색
        int minCost = Integer.MAX_VALUE;

        // 루프 변수는 언덕의 최소 높이다.
        for (int height = 0; height <= 83; height++) {

            int cost = 0;
            for (int j = 0; j < N; j++) {
                // 1. 최저 높이: height 보다 작은 경우
                if (hills[j] < height) {
                    cost += mul(height - hills[j]);
                }

                // 2. 최고 높이: height + 17보다 큰 경우
                else if (hills[j] > height + 17) {
                    cost += mul(height + 17 - hills[j]);
                }
                // 3. 범위에 속하는 경우 - continue
            }
            // 비용 최솟값 갱신
            if (cost < minCost) minCost = cost;
        }
        System.out.println(minCost);
    }

    private static int mul(int i) {
        return i * i;
    }
}
