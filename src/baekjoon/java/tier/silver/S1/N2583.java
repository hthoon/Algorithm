package baekjoon.java.tier.silver.S1;

import java.io.*;
import java.util.*;

public class N2583 {
    /**
     * 영역 찾기 - BFS, 레벨 탐색
     */
    static int rows, cols;
    static int[][] area;
    static int[] dirRow = {-1, 1, 0, 0};
    static int[] dirCol = {0, 0, -1, 1};
    static int extent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 지역 배열 초기화
        // -1: 초기 상태, 0: 채워진 지역, 1: 방문 지역
        area = new int[rows][cols];
        for (int[] row : area) {
            Arrays.fill(row, 0);
        }

        // 직사각형 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            fillArea(y1, x1, y2, x2);
        }

        // BFS 시작점 탐색
        List<Integer> extents = new ArrayList<>();
        int parts = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (area[row][col] == 0) {
                    area[row][col] = 1;
                    extent = 1;
                    findArea(encodeCoord(row, col));
                    parts++;
                    extents.add(extent);
                }
            }
        }
        extents.sort(Integer::compare);
        StringBuilder answer = new StringBuilder();
        for (int e : extents) {
            answer.append(e).append(" ");
        }

        System.out.println(parts);
        System.out.print(answer);
    }

    private static void findArea(int encodedCoord) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(encodedCoord);

        int[] decodedCoord;
        while (!queue.isEmpty()) {
            decodedCoord = decodeCoord(queue.poll());
            int row = decodedCoord[0];
            int col = decodedCoord[1];

            for (int k = 0; k < 4; k++) {
                int nextRow = row + dirRow[k];
                int nextCol = col + dirCol[k];

                if (nextRow >= rows || nextRow < 0 || nextCol >= cols || nextCol < 0 ) continue;
                if (area[nextRow][nextCol] == -1 || area[nextRow][nextCol] == 1) continue;

                queue.offer(encodeCoord(nextRow, nextCol));
                area[nextRow][nextCol] = 1;
                extent++;
            }
        }
    }

    /* 헬퍼 함수 */
    private static void fillArea(int r1, int c1, int r2, int c2) {
        for (int row = r1; row < r2; row++) {
            for (int col = c1; col < c2; col++) {
                area[row][col] = -1;
            }
        }
    }

    // 좌표 인코더
    private static int encodeCoord(int row, int col) {
        return row * cols + col;
    }

    // [0]: row, [1]: col
    private static int[] decodeCoord(int encodedCoord) {
        return new int[] {encodedCoord / cols, encodedCoord % cols};
    }
}