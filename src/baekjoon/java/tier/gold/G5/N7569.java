package baekjoon.java.tier.gold.G5;

import java.io.*;
import java.util.*;

public class N7569 {
    /**
     * 토마토(적층형) - BFS, 3차원, 6방향 탐색, 레벨 탐색
     */
    static int totalRow, totalCol, height;
    static int[][][] tomatoes;
    static Queue<int[]> next;
    static int raw = 0;
    static int days;

    static int[] directionZ = {1, -1, 0, 0, 0, 0};   // 위, 아래
    static int[] directionRow = {0, 0, -1, 1, 0, 0}; // 상, 하
    static int[] directionCol = {0, 0, 0, 0, 1, -1}; // 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        totalCol = Integer.parseInt(st.nextToken()); // 2 <= totalCol <= 100
        totalRow = Integer.parseInt(st.nextToken()); // 2 <= totalRow <= 100
        height = Integer.parseInt(st.nextToken());   // 1 <= height <= 100

        tomatoes = new int[height][totalRow][totalCol];    // (층, 세로, 가로) 토마토 배열
        next = new ArrayDeque<>();                         // 시작 위치(익은 토마토) 저장 큐
        // 층
        for (int z = 0; z < height; z++) {
            // 세로
            for (int y = 0; y < totalRow; y++) {
                // 가로
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < totalCol; x++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoes[z][y][x] = tomato;

                    // 조기 종료를 위해 안 익은 토마토의 수 카운팅
                    if (tomato == 0) {
                        raw++;
                    }
                    // 익은 토마토의 위치를 큐에 삽입
                    else if (tomato == 1) {
                        int[] coord = {z, y, x};
                        next.offer(coord);
                    }
                }
            }
        }

        // Early return 1: 모든 토마토가 익어 있음
        if (raw == 0) {
            System.out.print(0);
            return;
        }
        // Early return 2: 익어 있는 토마토가 없음
        if (next.isEmpty()) {
            System.out.print(-1);
            return;
        }

        days = -1;

        /* BFS 시작 */
        // 배열 요소로 방문 필요성을 파악할 수 있기 때문에 방문 배열을 사용하지 않음
        while (!next.isEmpty()) {
            // 일간 반복 횟수
            int cycle = next.size();
            for (int i = 0; i < cycle; i++) {
                int[] current = next.poll();
                int currentZ = current[0];
                int currentY = current[1];
                int currentX = current[2];

                // 6방향 탐색
                for (int k = 0; k < 6; k++) {
                    int nextZ = currentZ + directionZ[k];
                    int nextY = currentY + directionRow[k];
                    int nextX = currentX + directionCol[k];

                    /* 루프 스킵 */
                    if (nextZ < 0 || nextZ >= height || nextY < 0 || nextY >= totalRow || nextX < 0 || nextX >= totalCol) continue;
                    if (tomatoes[nextZ][nextY][nextX] == -1 || tomatoes[nextZ][nextY][nextX] == 1) continue;

                    /* 다음 탐색 큐에 좌표 삽입 */
                    if (tomatoes[nextZ][nextY][nextX] == 0) {
                        tomatoes[nextZ][nextY][nextX] = 1;
                        next.offer(new int[]{nextZ, nextY, nextX});
                        raw--;
                    }
                }
            }
            days++;
        }
        if (raw > 0) {
            System.out.print(-1);
            return;
        }
        System.out.print(days);
    }
}