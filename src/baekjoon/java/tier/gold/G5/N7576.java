package baekjoon.java.tier.gold.G5;

import java.io.*;
import java.util.*;

public class N7576 {
    /**
     * 토마토 - BFS, 레벨 탐색
     */
    static int cols;
    static int rows;
    static Queue<Integer> next;
    static int days;
    static int[] directionRow = {-1, 1, 0, 0};
    static int[] directionCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cols = Integer.parseInt(st.nextToken()); // 2 <= M <= 1000
        rows = Integer.parseInt(st.nextToken()); // 2 <= N <= 1000

        next = new ArrayDeque<>();

        // -1: 공란, 0: 안 익은 토마토, 1: 익은 토마토
        int count = 0;
        int[][] tomatoes = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < cols; col++) {
                int space = Integer.parseInt(st.nextToken());
                tomatoes[row][col] = space;

                // 익은 토마토의 좌표는 탐색 큐에 삽입
                if (space == 0) {
                    count++;
                }
                else if (space == 1) {
                    next.offer(encodeCoord(row, col));
                }
            }
        }

        // 예외 1. 토마토가 모두 익은 상태면 0을 출력
        if (count == 0) {
            System.out.print(count);
            return;
        }

        /* 접근
        * 1 0
        * 0 0
        *
        * 하루 단위로 토마토를 익혀(?)야 한다.
        * 위와 같은 토마토 배열이 있으면,
        * -> (0, 0), (1, 1) 좌표를 한 번에 담는다.
        * -> (0, 0), (1, 1) 좌표의 토마토를 후숙 처리
        * -> (1, 0) 좌표를 담는다.
        * -> (1, 0) 좌표의 토마토를 후숙 처리
        * -> 루프 하나를 하루 단위로 간주하여 반복한다.
        * */

        days = -1;

        while (!next.isEmpty()) {
            /* 현재 큐의 길이만큼 반복 */
            int cycle = next.size(); // 하루 단위 탐색을 위한 루프 설정
            for (int i = 0; i < cycle; i++) {
                int encodedCoord = next.poll();
                int currentRow = encodedCoord / cols;
                int currentCol = encodedCoord % cols;

                /* 사방탐색 */
                for (int k = 0; k < 4; k++) {
                    int nextRow = currentRow + directionRow[k];
                    int nextCol = currentCol + directionCol[k];

                    /* 루프 스킵 */
                    if (nextRow >= rows || nextRow < 0 || nextCol >= cols || nextCol < 0) continue; // 경계 처리
                    if (tomatoes[nextRow][nextCol] == -1) continue;                                 // 토마토가 없는 칸

                    /* 후숙 처리 */
                    if (tomatoes[nextRow][nextCol] == 0) {
                        tomatoes[nextRow][nextCol] = 1;
                        next.offer(encodeCoord(nextRow, nextCol));
                    }
                }
            }
            days++;
        }

        // 예외 2. 토마토가 모두 익지 못하는 상황
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (tomatoes[row][col] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(days);
    }

    private static int encodeCoord(int row, int col) {
        return row * cols + col;
    }
}
