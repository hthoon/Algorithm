package baekjoon.java.tier.silver.S2;

import java.io.*;
import java.util.*;

public class N24445 {
    /**
     * 알고리즘 수업 - 너비 우선 탐색 1 - BFS
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 5 <= N <= 100000, 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 200000, 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 1 <= R <= N, 시작 정점

        List<Integer>[] nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            nodes[prev].add(next);
            nodes[next].add(prev);
        }

        // 큰 정점부터 방문하기 위해 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            nodes[i].sort((a, b) -> b - a);
        }

        boolean[] visited = new boolean[N + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(R);
        int order = 1;
        int[] visitedAt = new int[N + 1];

        visited[R] = true;
        visitedAt[R] = order;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : nodes[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    visitedAt[next] = ++order;
                    queue.offer(next);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(visitedAt[i]).append("\n");
        }
        System.out.print(answer);
    }
}
