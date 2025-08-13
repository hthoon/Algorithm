package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.*;

public class N2178 {
    /**
     * 미로 탐색 - BFS, 사방탐색, 좌표 인코딩 / 디코딩
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 2 <= N <= 100 - 세로(행 개수)
        int M = Integer.parseInt(st.nextToken()); // 2 <= M <= 100 - 가로(열 개수)

        /* 격자 배열 미로 생성 */
        boolean[][] maze = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (line[j] == '1') {
                    maze[i][j] = true;
                }
            }
        }

        boolean[][] visited = new boolean[N][M]; // 방문 체크 배열
        int[][] totalDist = new int[N][M];       // 소요 거리 저장 배열

        findExit(maze, visited, totalDist);

        // 종료 지점 최단 거리 - (N - 1, M - 1)
        System.out.print(totalDist[N - 1][M - 1]);
    }

    /* BFS 사용. DFS 사용 시 갈림길 분기 처리의 복잡성, 막다른 길 방문 시 시간이 낭비될 것으로 예상 */
    private static void findExit(boolean[][] maze, boolean[][] visited, int[][] totalDist) {
        // 시작점 - (0, 0)
        visited[0][0] = true;
        totalDist[0][0] = 1;

        Queue<Integer> next = new ArrayDeque<>();
        next.offer(0);

        // 행, 열 정보
        int maxRow = maze.length;    // 최대 행
        int maxCol = maze[0].length; // 최대 열

        // 사방탐색
        int[] directionRow = {-1, 1, 0, 0}; // 행 방향 - 상, 하
        int[] directionCol = {0, 0, -1, 1}; // 열 방향 - 좌, 우

        while (!next.isEmpty()) {
            int currentCoord = next.poll();
            int row = decodeRow(currentCoord, maxCol);
            int col = decodeCol(currentCoord, maxCol);

            for (int k = 0; k < 4; k ++) {
                // 1. 다음 행선지
                int nextRow = row + directionRow[k];
                int nextCol = col + directionCol[k];

                // 2. 경계 판별
                if (nextRow >= maxRow || nextRow < 0 || nextCol >= maxCol || nextCol < 0) {
                    continue;
                }

                // 3. 유효한 길 판별
                if (!maze[nextRow][nextCol]) {
                    continue;
                }

                // 4. 방문 여부 판별
                if (visited[nextRow][nextCol]) {
                    continue;
                }

                // 5. 방문 처리
                totalDist[nextRow][nextCol] = totalDist[row][col] + 1; // 현재 길까지의 거리 저장
                visited[nextRow][nextCol] = true;                      // 방문 처리

                // 6. 좌표 인코딩 후 다음 행선지 큐에 삽입
                next.offer(encodeCoord(nextRow, nextCol, maxCol));
            }
        }
    }

    /* Integer 큐에 좌표값을 삽입하기 위한 인코딩 메서드 */
    private static int encodeCoord(int row, int col, int totalCol) {
        return row * totalCol + col;
    }

    /* row 디코딩 메서드 */
    private static int decodeRow(int index, int totalCol) {
        return index / totalCol;
    }

    /* col 디코딩 메서드 */
    private static int decodeCol(int index, int totalCol) {
        return index % totalCol;
    }
}
