package baekjoon.java.tier.silver.S1;

import java.io.*;
import java.util.*;

public class N14940 {
    /**
     * 쉬운 최단거리 - BFS
     */
    static int rows, cols;
    static int[][] map;
    static int[] dirRow = {1, -1, 0, 0};
    static int[] dirCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken()); // 세로
        cols = Integer.parseInt(st.nextToken()); // 가로

        map = new int[rows][cols];
        int startingPoint = 0;
        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                int ground = Integer.parseInt(st.nextToken());
                /*  탐색 시 방문/미방문 좌표 혼동을 막기 위한 처리 */
                // 시작 지점의 좌표 저장
                if (ground == 2) {
                    startingPoint = encodeCoord(i, j);
                }
                // 갈 수 있는 땅은 -1로 저장
                else if (ground == 1) {
                    map[i][j] = -1;
                }
                // 갈 수 없는 땅은 0
                else {
                    map[i][j] = 0;
                }
            }
        }

        findDists(startingPoint);

        StringBuilder answer = new StringBuilder();
        for (int[] rows : map) {
            for (int dist : rows) {
                answer.append(dist).append(" ");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }

    private static void findDists(int encodedStartingPoint) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(encodedStartingPoint);

        int[] start = decodeCoord(encodedStartingPoint);
        map[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] currCoord = decodeCoord(queue.poll());
            int currRow = currCoord[0];
            int currCol = currCoord[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + dirRow[i];
                int nextCol = currCol + dirCol[i];

                /* 방문 불가 처리 */
                // -1: 갈 수 있는 땅, 0: 갈 수 없는 땅
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) continue;
                if (map[nextRow][nextCol] >= 0) continue;

                /* 방문 처리 */
                map[nextRow][nextCol] = map[currRow][currCol] + 1;
                queue.offer(encodeCoord(nextRow, nextCol));
            }
        }
    }

    private static int encodeCoord(int row, int col) {
        return row * cols + col;
    }

    private static int[] decodeCoord(int encodedCoord) {
        return new int[] {encodedCoord / cols, encodedCoord % cols};
    }
}
