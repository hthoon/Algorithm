package baekjoon.java.solved_class.class3.essential;

import java.io.*;
import java.util.*;

public class N11724 {
    /**
     * 연결 요소의 개수
     */
    static List<Integer>[] connections;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1000 - 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 0 <= M <= N * (N - 1) / 2 - 간선의 수

        /* 무방향 그래프 */
        connections = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            connections[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            connections[u].add(v);
            connections[v].add(u);
        }

        /* 조건문 한 사이클 -> component 1개 */
        boolean[] visited = new boolean[N + 1];
        int components = 0;

        // 모든 component 탐색 위해 노드 전수조사
        for (int i = 1; i < connections.length; i++) {
            // 미방문 노드 발견 시 DFS 수행 및 카운팅
            if (!visited[i]) {
                findComponent(visited, i);
                components++;
            }
        }
        System.out.print(components);
    }

    // 방문 처리를 위한 DFS
    private static void findComponent(boolean[] visited, int v) {
        visited[v] = true;

        for (int next : connections[v]) {
            if (!visited[next]) {
                findComponent(visited, next);
            }
        }
    }
}
