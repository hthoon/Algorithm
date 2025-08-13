package baekjoon.java.tier.silver.S2;

import java.io.*;
import java.util.*;

public class N2644 {
    /**
     * 촌수 계산 - BFS
     */
    static List<Integer>[] cousinConnections;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());        // 전체 사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken()); // 촌수 계산 대상 1
        int target2 = Integer.parseInt(st.nextToken()); // 촌수 계산 대상 2

        int m = Integer.parseInt(br.readLine());        // 관계의 수

        /*
        * 1----
        * |   |
        * |   3
        * |
        * 2--------
        * |   |   |
        * |   |   |
        * 7   8   9
        *
        * 7을 나로 가정했을 때,
        * 1촌 -> 2
        * 2촌 -> 1, 8, 9
        * 3촌 -> 3
        *
        * 촌수는 '노드의 수'
        * */

        cousinConnections = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            cousinConnections[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken()); // 부모
            int next = Integer.parseInt(st.nextToken()); // 자식

            cousinConnections[prev].add(next);
            cousinConnections[next].add(prev);
        }
        System.out.print(findCousin(target1, target2, n));
    }

    /* BFS */
    private static int findCousin(int start, int target, int members) {
        boolean[] visited = new boolean[members + 1];
        int[] dist = new int[members + 1];

        visited[start] = true;
        dist[start] = 0;

        Queue<Integer> next = new ArrayDeque<>();
        next.offer(start);

        while (!next.isEmpty()) {
            int current = next.poll();

            // 직계 방문 처리
            visited[current] = true;

            for (int connection : cousinConnections[current]) {
                if (visited[connection]) continue;      // 재방문 처리

                visited[connection] = true;             // 방문 처리
                dist[connection] = dist[current] + 1;   // 촌수 기록

                // 목표 대상 발견: 나와의 최단 거리 반환하며 종료
                if (connection == target) {
                    return dist[connection];
                }

                // 큐에 다음 탐색 대상 저장
                next.offer(connection);
            }
        }
        // 사이클 내에 존재하지 않을 경우
        return -1;
    }
}
