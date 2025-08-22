package baekjoon.java.tier.silver.S2;

import java.io.*;
import java.util.*;

public class N24479 {
    /**
     * 알고리즘 수업 = 깊이 우선 탐색 1 - DFS
     */
    static List<Integer>[] nodes;
    static boolean[] visited;
    static int[] visitedAt;
    static int order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 5 <= N <= 100000, 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 200000, 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 1 <= R <= N, 시작 정점

        /* 양방향 노드 집합 */
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        /* 노드 입력 */
        for (int i = 1; i <= M; i ++) {
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            nodes[prev].add(next);
            nodes[next].add(prev);
        }

        // 중요: 작은 수부터 순차 방문 위해 정렬
        for (int i = 1; i <= N; i++) {
            nodes[i].sort(Integer::compare);
        }

        visited = new boolean[N + 1];
        visitedAt = new int[N + 1];
        order = 0;

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visitedAt[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int R) {
        visited[R] = true;
        order++;
        visitedAt[R] = order;

        for (int next : nodes[R]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
