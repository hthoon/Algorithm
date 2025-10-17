package baekjoon.java.tier.silver.S3;

import java.io.*;
import java.util.*;

public class N15649 {
    /**
     * N과 M (1) - DFS, 백트래킹
     */
    static int N, M;
    static int[] memo;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수열을 만들 숫자의 범위
        M = Integer.parseInt(st.nextToken()); // depth

        // N개의 수로, M 길이의 수열을 만들어야 한다.
        memo = new int [N + 1];
        visited = new boolean[N + 1];

        backTrack(0);

        System.out.print(answer);
    }

    private static void backTrack(int depth) {
        // 원하는 깊이(수열의 길이) 도달
        if (depth == M) {
            for (int i = 0; i < depth; i++) {
                answer.append(memo[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int num = 1; num <= N; num++) {
            // 재방문
            if (visited[num]) continue;

            // 최초 방문
            visited[num] = true;
            memo[depth] = num;
            backTrack(depth + 1);

            // 백트래킹 - 모든 경우의 수를 탐색할 수 있도록 방문 처리 해제
            visited[num] = false;
        }
    }
}
