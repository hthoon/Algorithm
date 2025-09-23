package baekjoon.java.tier.silver.S1;

import java.io.*;
import java.util.*;

public class N1697 {
    /**
     * 숨바꼭질 - BFS, 최단 거리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        // 조기 종료: 수빈이가 동생의 위치와 같거나, 동생보다 앞선 경우
        if (N >= K) {
            System.out.print(N - K);
            return;
        }

        // 거리를 기록할 배열. 방문 여부 구분을 위해 도달 불가능한 값으로 초기화
        final int MAX = 100000;
        int[] dists = new int[MAX + 1];

        Arrays.fill(dists, -1);
        dists[N] = 0;

        // 수빈 위치에서 탐색 시작
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int X = queue.poll();

            // 종료 조건: 수빈이와 동생의 좌표가 동일
            if (X == K) {
                System.out.print(dists[X]);
                return;
            }

            // 이동 방향은 X - 1, X + 1, 2 * X
            int[] nextDist = {X - 1, X + 1, X * 2};

            for (int next : nextDist) {
                // 경계 처리
                if (next > MAX || next < 0) continue;

                // 미방문 좌표일 경우, (이전 이동 방향까지의 시간 소요 + 1)을 기록
                if (dists[next] == -1) {
                    dists[next] = dists[X] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
