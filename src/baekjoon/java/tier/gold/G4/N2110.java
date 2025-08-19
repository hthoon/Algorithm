package baekjoon.java.tier.gold.G4;

import java.io.*;
import java.util.*;

public class N2110 {
    /**
     * 공유기 설치 - 이분 탐색, 그리디
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 2 <= N <= 200000,
        int C = Integer.parseInt(st.nextToken()); // 2 <= C <= N,

        /* 집의 좌표 배열 */
        long[] houses = new long[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Long.parseLong(br.readLine());
        }

        // 좌표 정렬
        Arrays.sort(houses);

        long left = 1;                          // 최소 거리
        long right = houses[N - 1] - houses[0]; // 최대 거리
        long maxDist = 0;                       // 가장 인접한 공유기 간의 거리

        /*
        1 - 2 - x - 4 - x - x - x - 8 - 9
        O-----------O               O
        O-----------O                   O

        위의 O---O이 가장 인접한 공유기 간의 최대 거리다.
         */

        while (left <= right) {
            long mid = left + (right - left) / 2;
            int devices = 1;       // 설치한 공유기 수, 첫 번째 집은 항상 설치하므로 1 시작
            long last = houses[0]; // 마지막으로 공유기를 설치한 집의 위치

            /* 공유기 배치 */
            for (int i = 1; i < N; i++) {
                // 마지막으로 공유기를 설치한 집과의 간격을 비교한다.
                if (houses[i] - last >= mid) {
                    devices++;
                    last = houses[i];
                }
            }

            // 공유기 수가 남으면 간격을 넓힌다.
            if (devices >= C) {
                maxDist = mid;
                left = mid + 1;
            }
            // 공유기 수가 적으면 간격을 좁힌다.
            else {
                right = mid - 1;
            }
        }
        System.out.print(maxDist);
    }
}
