package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.*;

public class N1260 {
    /**
     * DFS와 BFS
     * */
    static List<Integer>[] nodes;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1000 - 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 10000 - 간선의 수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호

        /* 조건 1: 양방향 그래프 */
        // 양방향 그래프 생성
        nodes = new ArrayList[N + 1];
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

        /* 조건 2: 방문할 수 있는 정점이 여러 개인 경우, 작은 것을 먼저 방문 */
        // 미리 오름차순 정렬 처리 (sort 인자로 Integer::compare 람다식을 넣어줄 수 있다.)
        for (List<Integer> nextNodes : nodes) {
            if (nextNodes != null) {
                nextNodes.sort((a, b) -> a - b);
            }
        }

        /* DFS */
        boolean[] dfsVisited = new boolean[N + 1];
        dfs(dfsVisited, V);
        sb.append("\n");

        /* BFS */
        boolean[] bfsVisited = new boolean[N + 1];
        bfs(bfsVisited, V);

        System.out.println(sb);
    }

    private static void dfs(boolean[] visited, int v) {
        // 방문처리
        visited[v] = true;
        sb.append(v).append(" ");

        /* 탐색 */
        // 미리 정렬 처리를 했기 때문에, 다음 노드만 탐색하면 된다.
        for (int next : nodes[v]) {
            if (!visited[next]) {
                dfs(visited, next);
            }
        }
    }

    private static void bfs(boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();

        // 0. 시작 정점 삽입 및 방문 처리
        queue.add(v);
        visited[v] = true;

        // 큐에 값이 있는 한, 탐색을 계속한다.
        while (!queue.isEmpty()) {
            // 1. 큐에서 값을 꺼내기 + 결과 저장
            int current = queue.poll();
            sb.append(current).append(" ");

            // 2. 해당 값과 인접한 모든 노드를 탐색한다.
            // 방문하지 않은 값일 경우, 큐에 삽입 및 방문 처리한다.
            for (int next : nodes[current]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
