package baekjoon.java.tier.silver.S1;

import java.io.*;
import java.util.*;

public class N2468 {
    /**
     * 안전구역 - BFS
     */
    static int N;
    static int[][] area;
    static Set<Integer> heights;
    static boolean[][] visited;
    static int[] dirRow = {0, 0, -1, 1}; // 상, 하
    static int[] dirCol = {-1, 1, 0, 0}; // 좌, 우
    static int safeAreas;
    static int maxSafeAreas;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 지역 넓이(정방형)

        area = new int[N][N];
        heights = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                area[i][j] = height;
                heights.add(height);
            }
        }

        // 추가: 비가 오지 않는 경우
        heights.add(0);

        /*
        1. 지역별 높이를 기준으로 탐색 루프 생성
        2. BFS 시작 지점 탐색
        3. BFS 탐색 수행 + 안전 지역 수 카운팅

         */

        /* 외부 루프: 지역별 높이 기준 */
        for (int rainfall : heights) {
            /* 내부 루프: BFS 시작 지점 탐색 */
            // 탐색에 필요한 요소 초기화
            visited = new boolean[N][N];
            safeAreas = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] > rainfall && !visited[i][j]) {
                        safeAreas++;
                        findSafeAreas(rainfall, i, j);
                    }
                }
            }

            // 안전 지역 최댓값 갱신
            if (safeAreas > maxSafeAreas) {
                maxSafeAreas = safeAreas;
            }
        }
        System.out.print(maxSafeAreas);
    }

    private static void findSafeAreas(int rainfall, int row, int col) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[row][col] = true;
        queue.offer(encodeCoord(row, col));

        int[] coord = new int[2];
        while (!queue.isEmpty()) {
            coord = decodeCoord(queue.poll());

            int currentRow = coord[0];
            int currentCol = coord[1];

            for (int i = 0; i < 4; i ++) {
                int nextRow = currentRow + dirRow[i];
                int nextCol = currentCol + dirCol[i];

                // 경계 및 재방문 처리
                if (nextRow >= N || nextRow < 0 || nextCol >= N || nextCol < 0) continue;
                if (visited[nextRow][nextCol]) continue;

                // 방문 처리
                if (!visited[nextRow][nextCol] && area[nextRow][nextCol] > rainfall) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(encodeCoord(nextRow, nextCol));
                }
            }
        }

    }

    private static int encodeCoord(int row, int col) {
        return row * N + col;
    }

    // [0] - row, [1] - col
    private static int[] decodeCoord(int encodedCoord) {
        return new int[] {encodedCoord / N, encodedCoord % N};
    }
}
