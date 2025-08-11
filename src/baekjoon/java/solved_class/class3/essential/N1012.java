package baekjoon.java.solved_class.class3.essential;

import java.io.*;
import java.util.*;

public class N1012 {
    /**
     * 유기농 배추 - DFS
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 50, 가로
            int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 50, 세로
            int K = Integer.parseInt(st.nextToken()); // 1 <= K <= 2500, 배추 수

            /* 배추밭 짓기 */
            // 주의: 가로, 세로 헷갈리지 말 것
            boolean[][] field = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = true;
            }

            /* 방문 여부 확인 배열 */
            boolean[][] visited = new boolean[N][M];

            int worms = 0;
            /* 좌상단 -> 우하단 탐색 시작 */
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    /* 배추 발견 시 지렁이 풀기 */
                    if (field[y][x] && !visited[y][x]) {
                        worms++;
                        debug(field, visited, y, x);
                    }
                }
            }
            sb.append(worms).append("\n");
        }
        System.out.print(sb);
    }

    private static void debug(boolean[][] field, boolean[][] visited, int y, int x) {
        /* 방문 처리 */
        visited[y][x] = true;

        /* 사방 탐색 */
        // 상
        if (y - 1 >= 0 && field[y - 1][x] && !visited[y - 1][x]) {
            debug(field, visited, y - 1, x);
        }
        // 하
        if (y + 1 < field.length && field[y + 1][x] && !visited[y + 1][x]) {
            debug(field, visited, y + 1, x);
        }
        // 좌
        if (x - 1 >= 0 && field[y][x - 1] && !visited[y][x - 1]) {
            debug(field, visited, y, x - 1);
        }
        // 우
        if (x + 1 < field[0].length && field[y][x + 1] && !visited[y][x + 1]) {
            debug(field, visited, y, x + 1);
        }
    }
}
